package com.example.bmi_calc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edtWeight, edtHeightFt,edtHeightIn;
        Button  btnCalculate;
        TextView txtResult;
        LinearLayout llmain;

        edtWeight = findViewById(R.id.editWeight);
        edtHeightFt = findViewById(R.id.editHightFt);
        edtHeightIn = findViewById(R.id.editHightIn);
        btnCalculate = findViewById(R.id.btnCalculater);
        txtResult = findViewById(R.id.textResult);
        llmain = findViewById(R.id.llmain);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // edtWeight.getText().toString();  string ko integer me conver kiya
                int wt = Integer.parseInt( edtWeight.getText().toString());
                int ft = Integer.parseInt( edtHeightFt.getText().toString());
                int in = Integer.parseInt( edtHeightIn.getText().toString());

                int totalIn = ft*12 + in;
                // kisi bhi int valu ko . ke liye double letay hai
                // CM centemeter
                double totalCm = totalIn*2.53;
                //CM ko M banaya
                double totalM = totalCm/100;
                // formula
                double bmi = wt/(totalM*totalM);

                if (bmi>25) {
                    txtResult.setText("you're over weight");
                    llmain.setBackgroundColor(getResources().getColor(R.color.purple_200));
                } else if(bmi<18){
                    txtResult.setText("you're underweight");
                    // llmain.setBackground(getResources().getDrawable(R.drawable.ic_launcher_background));
                    llmain.setBackgroundColor(getResources().getColor(R.color.teal_200));
                }else {
                    txtResult.setText("you're healthy");
                    llmain.setBackgroundColor(getResources().getColor(R.color.black));
                }
            }
        });
    }
}
