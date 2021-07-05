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
    private EditText editText_password;
    private EditText editText_email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        sign_up = findViewById(R.id.sign_up_btn);
        editText_name = findViewById(R.id.name_create);
        editText_email = findViewById(R.id.email_create);
        editText_password = findViewById(R.id.password_create);
        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this, HomeActivity.class);
                String name = editText_name.getText().toString();
                if (name_validate() && email_validate() && password_validate()) {
                    intent.putExtra("name", name);
                    startActivity(intent);
                }
                else{

                }
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

    public boolean name_validate() {
        String name = editText_name.getText().toString();
        if (name.length() >= 4) {
            return true;
        } else {
            return false;
        }
    }

    public boolean email_validate() {
        String email = editText_email.getText().toString();
        if (email.length() > 5) {
            return true;
        } else {
            return false;
        }
    }

    public boolean password_validate() {
        String password = editText_password.getText().toString();
        if (password.length() >= 6) {
            return true;
        } else {
            return false;
        }
    }
}