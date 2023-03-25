package com.example.project.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.project.R;

import java.io.OutputStream;

public class CameraActivity extends AppCompatActivity {

    private static final int REQUEST_CAMERA_PERMISSION = 1;
    private static final int REQUEST_IMAGE_CAPTURE = 2;
    private static final int REQUEST_SAVE_IMAGE = 3;
    private ImageView mImageView;
    private Button mSimpanButton;
    private  Button mHapusButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        mImageView = findViewById(R.id.img_gambar);
        mSimpanButton = findViewById(R.id.btn_simpan);
        mHapusButton = findViewById(R.id.btn_hapus);

    }

    public void openCamera(View view) {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, REQUEST_CAMERA_PERMISSION);
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA)) {
            } else {
                Toast.makeText(this, "Aplikasi membutuhkan izin untuk menggunakan kamera", Toast.LENGTH_SHORT).show();
            }
        } else {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);
        }
    }



    public void simpanGambar(View view) {
        // cek apakah imageview sudah memiliki gambar
        if (mImageView.getDrawable() == null) {
            Toast.makeText(this, "Belum ada gambar yang diambil", Toast.LENGTH_SHORT).show();
            return;
        }

        // cek apakah sudah memiliki izin akses penyimpanan
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_SAVE_IMAGE);
        } else {
            // dapatkan gambar dari ImageView
            BitmapDrawable drawable = (BitmapDrawable) mImageView.getDrawable();
            Bitmap bitmap = drawable.getBitmap();

            // tampilkan dialog untuk memilih lokasi penyimpanan gambar
            Intent intent = new Intent(Intent.ACTION_CREATE_DOCUMENT);
            intent.addCategory(Intent.CATEGORY_OPENABLE);
            intent.setType("image/jpeg");
            intent.putExtra(Intent.EXTRA_TITLE, "gambar.jpg");
            startActivityForResult(intent, REQUEST_SAVE_IMAGE);
        }
    }

    public void hapusGambar(View view) {
        mImageView.setImageDrawable(null);
        mSimpanButton.setVisibility(View.GONE);
        findViewById(R.id.btn_hapus).setVisibility(View.GONE); // menyembunyikan tombol hapus
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            mImageView.setImageBitmap(imageBitmap);
            mSimpanButton.setVisibility(View.VISIBLE);
            mHapusButton.setVisibility(View.VISIBLE);

        } else if (requestCode == REQUEST_SAVE_IMAGE && resultCode == RESULT_OK) {
            // Simpan gambar ke lokasi yang dipilih
            Uri uri = data.getData();
            try {
                OutputStream outputStream = getContentResolver().openOutputStream(uri);
                BitmapDrawable drawable = (BitmapDrawable) mImageView.getDrawable();
                Bitmap bitmap = drawable.getBitmap();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);
                outputStream.flush();
                outputStream.close();
                Toast.makeText(this, "Gambar berhasil disimpan", Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(this, "Gagal menyimpan gambar", Toast.LENGTH_SHORT).show();
            }
            mSimpanButton.setVisibility(View.GONE);
        }
    }
}
