package com.komgrid.slideshow;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.nfc.Tag;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.ListResult;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class SlideshowActivity extends AppCompatActivity {
    private String nim;
    private ArrayList<String> imgUrls = new ArrayList<>();
    private ImageView imgSlideshow;
    private FirebaseStorage storage;

    Handler handler = new Handler();
    Runnable runnable;
    int delay = 1000;
    int i = 0;
    boolean finish = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slideshow);

        imgSlideshow = findViewById(R.id.imgSlideshow);

        storage = FirebaseStorage.getInstance();

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            nim = extras.getString("nim");
        }

        StorageReference listRef = storage.getReference().child("Grid2_" + nim);

        listRef.listAll()
                .addOnSuccessListener(new OnSuccessListener<ListResult>() {
                    @Override
                    public void onSuccess(ListResult listResult) {
                        for (StorageReference prefix : listResult.getPrefixes()) {
                            Log.e("prefix -> ", prefix.getPath());
                        }

                        for (StorageReference item : listResult.getItems()) {
                            imgUrls.add(item.getPath());
                            Log.e("Firestore error", item.getPath());
                        }
                        finish = true;
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        // Uh-oh, an error occurred!
                    }
                });


    }
    @Override
    protected void onResume() {
        handler.postDelayed(runnable = new Runnable() {
            public void run() {
                handler.postDelayed(runnable, delay);
                if(finish == true){
                    GlideApp.with(getApplicationContext()).load(storage.getReference(imgUrls.get(i))).diskCacheStrategy(DiskCacheStrategy.ALL).into(imgSlideshow);
                    i++;
                    if(i == 10) i = 0;
                }
            }
        }, delay);
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        handler.removeCallbacks(runnable); //stop handler when activity not visible super.onPause();
    }
}