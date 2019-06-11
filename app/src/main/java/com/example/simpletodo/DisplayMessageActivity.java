package com.example.simpletodo;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);
        Intent intent = getIntent();
        ListView textView = findViewById(R.id.lvItems);
    }
    public void createTask(View view){
        String task = ((EditText)findViewById(R.id.textNewTask)).getText().toString();
        if(task.equals("")){

        }
        else {
            Intent intent = new Intent();
            intent.putExtra(Intent_Constants.INTENT_MESSAGE_FIELD, task);
            setResult(Intent_Constants.INTENT_RESULT_CODE, intent);
            finish();
        }
    }
    public void cancelTask(View view){
        this.finish();
    }
}
