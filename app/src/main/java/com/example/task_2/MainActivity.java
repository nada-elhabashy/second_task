package com.example.task_2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    EditText et;
    TextView t;
    Button b1;
    Button b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et = findViewById(R.id.numberET);
        t = findViewById(R.id.displayTV);
        b1 = findViewById(R.id.showTheTextBTN);
        b2 = findViewById(R.id.searchTheWebBTN);

    }


    public boolean isNumber(String num) {

        boolean check = true;
        try {
            int res = Integer.parseInt(num);
        } catch (NumberFormatException e) {
            check = false;
        }
        return check;
    }

    public void showTheText(View v) {
        if (et.getText().toString().isEmpty()) {
            // Toast.makeText(this, "enter a valid number", Toast.LENGTH_LONG).show();
            et.setError("enter a valid number");
        } else {
            if (isNumber(et.getText().toString())) {
                t.setText(et.getText().toString());

            } else
                et.setError("enter a numeric value");
        }
    }

    public void searchTheWeb(View v) {
        if (et.getText().toString().isEmpty()) {

            et.setError("enter a valid number");
        } else {
            if (isNumber(et.getText().toString())) {

                Intent intet = new Intent(Intent.ACTION_WEB_SEARCH);

                intet.putExtra(SearchManager.QUERY, et.getText().toString());
                startActivity(intet);

            } else
                et.setError("enter a numeric value");
        }

    }


}



