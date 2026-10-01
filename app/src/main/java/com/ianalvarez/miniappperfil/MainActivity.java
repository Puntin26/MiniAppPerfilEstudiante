package com.ianalvarez.miniappperfil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_NAME = "name";
    public static final String EXTRA_STUDENT_ID = "student_id";
    public static final String EXTRA_CAREER = "career";

    private EditText txtName;
    private EditText txtStudentId;
    private Spinner spinnerCareer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtName = findViewById(R.id.txtName);
        txtStudentId = findViewById(R.id.txtStudentId);
        spinnerCareer = findViewById(R.id.spinnerCareer);
        Button btnSave = findViewById(R.id.btnSave);

        configureCareerSpinner();
        btnSave.setOnClickListener(view -> saveProfile());
    }

    private void configureCareerSpinner() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.careers,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCareer.setAdapter(adapter);
    }

    private void saveProfile() {
        String name = txtName.getText().toString().trim();
        String studentId = txtStudentId.getText().toString().trim();
        boolean isValid = true;

        if (name.isEmpty()) {
            txtName.setError(getString(R.string.required_name));
            isValid = false;
        }

        if (studentId.isEmpty()) {
            txtStudentId.setError(getString(R.string.required_student_id));
            isValid = false;
        }

        if (spinnerCareer.getSelectedItemPosition() == 0) {
            View selectedView = spinnerCareer.getSelectedView();
            if (selectedView instanceof TextView) {
                ((TextView) selectedView).setError(getString(R.string.required_career));
            }
            Toast.makeText(this, R.string.required_career, Toast.LENGTH_SHORT).show();
            isValid = false;
        }

        if (!isValid) {
            return;
        }

        Intent intent = new Intent(this, ProfileActivity.class);
        intent.putExtra(EXTRA_NAME, name);
        intent.putExtra(EXTRA_STUDENT_ID, studentId);
        intent.putExtra(EXTRA_CAREER, spinnerCareer.getSelectedItem().toString());
        startActivity(intent);
    }
}
