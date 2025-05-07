package  com.example.cosmesticappcongcu.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import  com.example.cosmesticappcongcu.R;
import  com.example.cosmesticappcongcu.databinding.ActivityIntroBinding;


public class IntroActivity extends AppCompatActivity {

    Button btnStart;
    private ActivityIntroBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityIntroBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
//        setContentView(R.layout.activity_intro);
        btnStart = (Button) findViewById(R.id.btnIntro);

        btnStart.setOnClickListener(view -> {
            Intent intent = new Intent(IntroActivity.this, LoginActivity.class);
            startActivity(intent);
        });
    }
}