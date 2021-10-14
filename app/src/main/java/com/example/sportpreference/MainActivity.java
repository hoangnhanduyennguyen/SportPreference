package com.example.sportpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText edName;
    RadioGroup rgSport;
    Button btnClear, btnNext, btnQuit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    //initialize the button
    private void initialize(){
        edName = findViewById(R.id.editName);
        rgSport = findViewById(R.id.rgSport);
        btnClear = findViewById(R.id.btnClear);
        btnClear.setOnClickListener(this);
        btnNext = findViewById(R.id.btnNext);
        btnNext.setOnClickListener(this);
        btnQuit = findViewById(R.id.btnQuit);
        btnQuit.setOnClickListener(this);

    }

    @Override
    public void onClick(View view){

        //get the id to see which button is clicked
        int id = view.getId();
        switch (id){
            case R.id.btnClear:
                clearWidgets();
                break;
            case R.id.btnNext:
                goToSecondActivity();
                break;
            case R.id.btnQuit:
                quitApp();
                break;
        }

    }

    // next button function
    private void goToSecondActivity(){
        String name = edName.getText().toString();
        //get the id of the radio button that is checked
        int idSport = rgSport.getCheckedRadioButtonId();

        // create the intent
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("name", name);
        intent.putExtra("sport",idSport);
        startActivity(intent);
    }

    //close the app
    private void quitApp(){
        System.exit(0);
    }

    //set text view to null and clear check for radio, checkbox, etc.
    private void clearWidgets(){
        edName.setText(null);
        rgSport.clearCheck();
    }
}