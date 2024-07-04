package com.example.tasklist;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class addTaskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_task);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText taskTitle = findViewById(R.id.etTaskTitle);
        EditText taskDuration = findViewById(R.id.etTaskDuration);
        EditText taskDescription = findViewById(R.id.etTaskDescription);
        EditText taskDueDate = findViewById(R.id.etDueDate);
        EditText taskCategory = findViewById(R.id.etTaskCategory);

        Button btnCancel = findViewById(R.id.btnCancelTask);
        Button btnSave = findViewById(R.id.btnSaveTask);

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cancelIntent = new Intent();
                setResult(RESULT_CANCELED,cancelIntent);
                finish();
            }
        });
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strTaskTitle = taskTitle.getText().toString();
                String intTaskDuration = taskDuration.getText().toString();
                String strTaskDescription = taskDescription.getText().toString();
                String strTaskDueDate = taskDueDate.getText().toString();
                String strTaskCategory = taskCategory.getText().toString();

                Task newTask = new Task(strTaskTitle,intTaskDuration,strTaskDescription,strTaskDueDate,strTaskCategory);
                Intent addIntent = new Intent();
                addIntent.putExtra("newTask",newTask);
                setResult(RESULT_OK,addIntent);
                finish();
            }
        });

    }
}