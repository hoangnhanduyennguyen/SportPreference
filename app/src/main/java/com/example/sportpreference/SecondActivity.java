package com.example.sportpreference;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener{

    TextView tvName, tvSport;
    Button btnReturn;

    @Override
    protected void onCreate(Bundle SaveInstanceState){
        super.onCreate(SaveInstanceState);
        setContentView(R.layout.activity_second);
        initialize();
    }

    private void initialize(){
        btnReturn = findViewById(R.id.btnReturn);
        //when click on the button
        btnReturn.setOnClickListener(this);
        tvName = findViewById(R.id.lblName);
        tvSport = findViewById(R.id.lblSport);

        //get data from text view
        String name = getIntent().getStringExtra("name");
        //get the text from the view (need to convert to String
        String label1 = tvName.getText().toString();
        tvName.setText(label1 + name);

        //get data from radio button -100 is like -1
        int idSport = getIntent().getIntExtra("sport",-100);
        String sport = "No Sport! You gonna die.";
        //String label2 = tvSport.getText().toString();

        switch (idSport){
            case R.id.rbSoccer:
                sport = "Soccer.";
                break;
            case R.id.rbHandball:
                sport = "Handball.";
                break;
            case R.id.rbHockey:
                sport = "Hockey.";
                break;
        }
        // add text to the end
        tvSport.append(sport);
    }

    //destroy the current view
    @Override
    public void onClick(View view) {
        finish();
    }
}
