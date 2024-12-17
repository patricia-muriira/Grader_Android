// MainActivity.java
package com.example.grader;
//CIT-227-014/2021
//Patricia Mwende Muriira
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText subject1, subject2, subject3, subject4, subject5;
    private TextView totalView, meanView, gradeView;
    private Button calculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        subject1 = findViewById(R.id.subject1);
        subject2 = findViewById(R.id.subject2);
        subject3 = findViewById(R.id.subject3);
        subject4 = findViewById(R.id.subject4);
        subject5 = findViewById(R.id.subject5);
        totalView = findViewById(R.id.total);
        meanView = findViewById(R.id.mean);
        gradeView = findViewById(R.id.grade);
        calculateButton = findViewById(R.id.calculateButton);

        // Button click listener
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateResults();
            }
        });
    }

    private void calculateResults() {
        try {
            // Get input values
            int s1 = Integer.parseInt(subject1.getText().toString());
            int s2 = Integer.parseInt(subject2.getText().toString());
            int s3 = Integer.parseInt(subject3.getText().toString());
            int s4 = Integer.parseInt(subject4.getText().toString());
            int s5 = Integer.parseInt(subject5.getText().toString());

            // Calculate total and mean
            int total = s1 + s2 + s3 + s4 + s5;
            int mean = total / 5;

            // Determine grade
            String grade;
            if (mean >= 80) {
                grade = "A";
            } else if (mean >= 69) {
                grade = "B";
            } else if (mean >= 50) {
                grade = "C";
            } else if (mean >= 40) {
                grade = "D";
            } else {
                grade = "E";
            }

            // Display results
            totalView.setText("Total: " + total);
            meanView.setText("Mean: " + mean);
            gradeView.setText("Grade: " + grade);
        } catch (NumberFormatException e) {
            totalView.setText("Please enter valid numbers for all subjects.");
            meanView.setText("");
            gradeView.setText("");
        }
    }
}
