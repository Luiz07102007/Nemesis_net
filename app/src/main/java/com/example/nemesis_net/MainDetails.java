package com.example.nemesis_net;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainDetails extends AppCompatActivity {
    private MediaPlayer clickSound;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_details);
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        decorView.setSystemUiVisibility(uiOptions);
        TextView textView = findViewById(R.id.text_tips);
        ImageView imageView = findViewById(R.id.starslogo);
        ImageView tipsimg = findViewById(R.id.img_tips);
        Intent intent = getIntent();
        int fototips = intent.getIntExtra("FOTOTIPS", 0);
        String dica = intent.getStringExtra("DICA_JOGO");
        tipsimg.setImageResource(fototips);
        textView.setText(dica);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        clickSound = MediaPlayer.create(this, R.raw.click);

        imageView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (clickSound != null) {
                    clickSound.start();
                }
                Intent intent = new Intent(MainDetails.this, MainLista.class);
                startActivity(intent);
                finish();
            };
        });
    }
}