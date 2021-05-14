package com.streamliners.sendingobjects;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.streamliners.sendingobjects.databinding.ActivityObjectViewerBinding;
import com.streamliners.sendingobjects.model.Student;

public class ObjectViewerActivity extends AppCompatActivity {
    ActivityObjectViewerBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityObjectViewerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Set the title of the activity
        setTitle("View Details");

        // Getting data through the intents
        getData();
    }

    /**
     * To get the data which is coming from another activity
     */
    private void getData() {
        // Validate student object which is coming through the intent
        Student student = getIntent().getExtras().getParcelable(Constants.STUDENT_KEY);

        // Checking that the student is not null
        if (student == null){
            Toast.makeText(this, "No data received!", Toast.LENGTH_SHORT).show();
            return;
        }

        // Showing data in the text fields
        binding.showNameTextField.setText(student.getName());
        binding.showGenderTextField.setText(student.getGender());
        binding.showRollNumberTextField.setText(student.getRollNumber());
        binding.showMobileNumberTextField.setText(student.getMobileNumber());
    }
}