package com.prabhakar.ft_and_03u_2c_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SignInActivity extends AppCompatActivity {
    private TextView signup_link;
    private TextView signin_btn;
    private EditText editText_name;
    private EditText editText_password;
    private EditText editText_email;
    private String email_pattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        signup_link = findViewById(R.id.signup_link);
        signin_btn = findViewById(R.id.sign_in_btn);
        editText_name = findViewById(R.id.name_create);
        editText_email = findViewById(R.id.email_create);
        editText_password = findViewById(R.id.password_create);
        signin_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignInActivity.this, HomeActivity.class);
                String name = editText_name.getText().toString();
                if (name_validate() && email_validate() && password_validate()) {
                    intent.putExtra("name", name);
                    startActivity(intent);
                }
            }
        });
        signup_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignInActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });

    }


    private boolean name_validate() {
        String name = editText_name.getText().toString();
        if (name.length() >= 4) {
            return true;
        } else {
            editText_name.setError("minimum 4 characters needed");
            return false;
        }
    }

    private boolean email_validate() {
        String email = editText_email.getText().toString();
        if (email.matches(email_pattern)) {
            return true;
        } else {
            editText_email.setError("invalid email");
            return false;
        }
    }

    private boolean password_validate() {
        String password = editText_password.getText().toString();
        if (password.length() >= 6) {
            return true;
        } else {
            editText_password.setError("password is incorrect");
            return false;
        }
    }
}
