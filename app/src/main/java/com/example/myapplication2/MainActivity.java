package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String SHAREDPREFS = "sharedprefs";
    public static final String KEYPWD = "keypwd";
    public static final String KEYNAME = "keyname";
    EditText nameEditText, pwdEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameEditText = findViewById(R.id.editTextTextPersonName);
        pwdEditText = findViewById(R.id.editTextTextPersonName2);
    }

    @Override
    protected void onResume() {
        super.onResume();
        restoreData();
    }

    private void restoreData() {
        SharedPreferences preferences = getSharedPreferences(SHAREDPREFS,MODE_PRIVATE);
        String name = preferences.getString(KEYNAME,"");
        String pwd = preferences.getString(KEYPWD,"");
        nameEditText.setText(name);
        pwdEditText.setText(pwd);

    }

    //on pause save the data
    @Override
    protected void onPause() {
        super.onPause();
        saveData();
    }

    private void saveData() {
        //get the data from edittext
        String name = nameEditText.getText().toString();
        String pwd = pwdEditText.getText().toString();
        //create file
        SharedPreferences preferences = getSharedPreferences(SHAREDPREFS, MODE_PRIVATE);
        //test case
        //open file
        SharedPreferences.Editor editor = preferences.edit();
        //write to file
        editor.putString(KEYNAME, name);
        editor.putString(KEYPWD, pwd);
        //save file
        editor.commit();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}