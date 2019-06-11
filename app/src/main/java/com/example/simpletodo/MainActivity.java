package com.example.simpletodo;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class MainActivity extends Activity {
    private ArrayList<String> taskList;
    private ArrayAdapter<String> itemsAdapter;
    private ListView lvItems;
    private Button button;
    String messageText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvItems = findViewById(R.id.lvItems);
        taskList = new ArrayList<String>();
        itemsAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, taskList);
        lvItems.setAdapter(itemsAdapter);

        button = (Button) findViewById(R.id.btnAddItemScreen);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goAddScreen();
            }
        });
    }
    public void goAddScreen(){
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, DisplayMessageActivity.class);
        startActivityForResult(intent, Intent_Constants.INTENT_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == Intent_Constants.INTENT_REQUEST_CODE){
            messageText = data.getStringExtra(Intent_Constants.INTENT_MESSAGE_FIELD);
            taskList.add(messageText);
            itemsAdapter.notifyDataSetChanged();
        }
    }
}

