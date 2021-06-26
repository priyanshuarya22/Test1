package com.example.test1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText et;
    Button b;
    LinearLayout ll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et = findViewById(R.id.et);
        b = findViewById(R.id.b1);
        ll = findViewById(R.id.ll);
        //this will enable the button to respond to clicks
        b.setOnClickListener(this);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View v) {
        //Removes all previous Views
        ll.removeAllViews();
        //get the number typed on the edit text
        int count = Integer.parseInt(et.getText().toString());
        //loop to display the new text views
        for (int i = 1; i <= count; i++) {
            TextView tv = new TextView(MainActivity.this);
            //this will enable text view to display context menu
            registerForContextMenu(tv);
            //setting text to be displayed
            tv.setText("Text View: " + i);
            tv.setTextSize(24);
            //adding text view to the layout
            ll.addView(tv);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mf = this.getMenuInflater();
        //inflate menu
        mf.inflate(R.menu.option_meu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //set text on edit text when clicked on a particular menu item
        //don't press go button after this
        //delete the text and enter a number to display text views again
        if(item.getItemId() == R.id.m1) {
            et.setText("You have clicked on Option 1");
        }
        else if(item.getItemId() == R.id.m2) {
            et.setText("You have clicked on Option 2");
        }
        else {
            et.setText("You have clicked on Option 3");
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater mf = this.getMenuInflater();
        //inflate context menu
        mf.inflate(R.menu.context_menu, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        //set text on edit text when clicked on a particular context item
        //don't press go button after this
        //delete the text and enter a number to display text views again
        if(item.getItemId() == R.id.cm1) {
            et.setText("You have clicked on Context Menu Option 1");
        }
        else if(item.getItemId() == R.id.cm2) {
            et.setText("You have clicked on Context Menu Option 2");
        }
        else {
            et.setText("You have clicked on Context Menu Option 3");
        }
        return super.onContextItemSelected(item);
    }
}