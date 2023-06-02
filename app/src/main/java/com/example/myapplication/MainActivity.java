package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplication.R;

public class MainActivity extends Activity implements View.OnClickListener {

    EditText etNum1;
    EditText etNum2;

    Button btnAdd;
    Button btnSub;
    Button btnMult;
    Button btnDiv;
    Button btnCnt;

    TextView tvResult;

    String operation = "";

    float result=0;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        etNum1 = (EditText) findViewById(R.id.etNum1);
        etNum2 = (EditText) findViewById(R.id.etNum2);
        btnCnt = (Button) findViewById(R.id.btnCnt);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnSub = (Button) findViewById(R.id.btnSub);
        btnMult = (Button) findViewById(R.id.btnMult);
        btnDiv = (Button) findViewById(R.id.btnDiv);

        tvResult = (TextView) findViewById(R.id.tvResult);


        btnCnt.setOnClickListener(this);
        btnAdd.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnMult.setOnClickListener(this);
        btnDiv.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        float num1 = 0;
        float num2 = 0;


        if (TextUtils.isEmpty(etNum1.getText().toString())
                || TextUtils.isEmpty(etNum2.getText().toString())) {
            return;
        }

        num1 = Float.parseFloat(etNum1.getText().toString());
        num2 = Float.parseFloat(etNum2.getText().toString());


        switch (v.getId()) {
            case R.id.btnAdd:
                operation = "+";
                result = num1 + num2;
                break;
            case R.id.btnSub:
                operation = "-";
                result = num1 - num2;
                break;
            case R.id.btnMult:
                operation = "*";
                result = num1 * num2;
                break;
            case R.id.btnDiv:
                operation = "/";
                result = num1 / num2;
                break;
            default:
                break;
        }
        tvResult.setText(num1 + " " + operation + " " + num2 + " = " + result);
        switch(v.getId()) {
            case R.id.btnCnt:
                num1 = result;
                tvResult.setText("");
                etNum1.setText(String.valueOf(num1));
                etNum2.setText("");
                break;
            default:
                break;
        }
    }
};