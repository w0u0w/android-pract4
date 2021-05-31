package ru.mirea.velikanov.thread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText days_form;
    EditText lessons_form;
    TextView textView;
    Integer days;
    Integer lessons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        days_form = findViewById(R.id.days);
        lessons_form = findViewById(R.id.lessons);
    }
    public void onClick(View view){
        Thread thread = new Thread(new Runnable() {
            public void run() {
                try {
                    days = Integer.parseInt(days_form.getText().toString());
                    lessons = Integer.parseInt(lessons_form.getText().toString());
                    textView = (TextView)findViewById(R.id.answer);
                    String setText = "Answer: " + days / lessons;
                    textView.setText(setText);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }
}