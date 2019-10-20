package com.example.calculateemi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    EditText et1,et2,et3;
    TextView result;
    Button calculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        et1 = findViewById(R.id.principal);
        et2  = findViewById(R.id.rate);
        et3 = findViewById(R.id.time);
        calculate =findViewById(R.id.calculate);
        result =findViewById(R.id.result);

        calculate.setOnClickListener (this);

    }

    @Override
    public void onClick(View v) {
        String principalStrng = et1.getText().toString();
        String rateString = et2.getText().toString();
        String timeString = et3.getText().toString();

        if (TextUtils.isEmpty(principalStrng)) {
            et1.setError("Enter loan Amount");
            et1.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(rateString)) {
            et2.setError("Enter Interest Rate");
            et2.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(timeString)) {
            et3.setError("Enter months");
            et3.requestFocus();
            return;
        }
        float principal = Float.parseFloat(et1.getText().toString ());
        float rate = Float.parseFloat(et2.getText().toString ());
        float time = Float.parseFloat(et3.getText().toString ());
        float   emi =  emical(principal,rate,time);
        result.setText(String.format("%.2f",emi));
    }

    static float emical(float p, float r, float t){
        float  r1 = r / (12 * 100);
        float t1 = t * 12;
        float em = (p * r1 * (float)Math.pow(1 + r1, t1)) / (float)(Math.pow(1 + r1, t1) - 1);

        return (em);
    }
}
