package com.faceng.jetpackdemo;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class AddUserActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY = "com.example.android.userlistsql.REPLY";

    private EditText mEtUserView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);
        mEtUserView = findViewById(R.id.edit_user);

        final Button button = findViewById(R.id.button_save);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent replyIntent = new Intent();
                if (TextUtils.isEmpty(mEtUserView.getText())) {
                    setResult(RESULT_CANCELED, replyIntent);
                } else {
                    String user = mEtUserView.getText().toString();
                    replyIntent.putExtra(EXTRA_REPLY, user);
                    setResult(RESULT_OK, replyIntent);
                }
                finish();
            }
        });
    }
}