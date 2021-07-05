package com.prabhakar.ft_and_03u_2c_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SignUpActivity extends AppCompatActivity {
    TextView sign_up;
    EditText editText_name;
    private TextView signing_link;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        sign_up = findViewById(R.id.sign_up_btn);
        editText_name = findViewById(R.id.name);
        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this, HomeActivity.class);
                String name = editText_name.getText().toString();
                intent.putExtra("name", name);
                startActivity(intent);
            }
        });
        signing_link = findViewById(R.id.signin_link);
        signing_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this, SignInActivity.class);
                startActivity(intent);
            }
        });
    }
}