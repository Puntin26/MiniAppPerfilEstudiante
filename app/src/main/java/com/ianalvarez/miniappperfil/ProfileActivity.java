package com.ianalvarez.miniappperfil;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        TextView txtGreeting = findViewById(R.id.txtGreeting);
        TextView txtName = findViewById(R.id.txtSavedName);
        TextView txtStudentId = findViewById(R.id.txtSavedStudentId);
        TextView txtCareer = findViewById(R.id.txtSavedCareer);
        Button btnEdit = findViewById(R.id.btnEdit);

        String name = getIntent().getStringExtra(MainActivity.EXTRA_NAME);
        String studentId = getIntent().getStringExtra(MainActivity.EXTRA_STUDENT_ID);
        String career = getIntent().getStringExtra(MainActivity.EXTRA_CAREER);

        txtGreeting.setText(getString(R.string.greeting_format, name));
        txtName.setText(getString(R.string.name_format, name));
        txtStudentId.setText(getString(R.string.student_id_format, studentId));
        txtCareer.setText(getString(R.string.career_format, career));

        Toast.makeText(this, R.string.profile_saved, Toast.LENGTH_SHORT).show();
        btnEdit.setOnClickListener(view -> finish());
    }
}
