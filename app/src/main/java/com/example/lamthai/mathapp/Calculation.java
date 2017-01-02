package com.example.lamthai.mathapp;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Calculation extends AppCompatActivity implements View.OnClickListener {

    TextView studentinfo,tvattempt,tvcorrect,tvaccurate,tvnumber1,tvnumber2,tvresult,tvoparator,tvstatus;
    TextView tvChooselv,tvChooseoptor,lbAttempt,lbCorrect,lbAccurate;
    Button btnAdd,btnSub,btnMul,btnDiv;
    Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9;
    Button btnc,btnBack,btnExit,btnNext,btnEnter;
    Spinner spnLevel;

    private static int j,numbercount;
    int num1;
    int num2;
    int selected;
    Random rand1 = new Random();
    Random rand2 = new Random();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculation);
        init();
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra(MainActivity.BUNLE);
        String string = "Student: " +bundle.getString(MainActivity.STNAME)+" "+ bundle.getString(MainActivity.STLASTNAME)+ " ID: "+ bundle.getString(MainActivity.STID);
        studentinfo.setText(string);
        setEvenclickview ();


        List<String> arrayLevel = new ArrayList<>();
        arrayLevel.add("Choose an level");
        arrayLevel.add("Beginer");
        arrayLevel.add("Intermediate");
        arrayLevel.add("Advanced");

        ArrayAdapter<String> adapter = new ArrayAdapter(this,android.R.layout.simple_dropdown_item_1line,arrayLevel);

        adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spnLevel.setAdapter(adapter);


        spnLevel.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                int temp;
            selected = spnLevel.getSelectedItemPosition();
                switch (position){
                    case 0:
                        break;
                    case  1:
                        temp = rand1.nextInt(10)+1;
                        if(temp<rand2.nextInt(10)+1) {
                            num1 = rand2.nextInt(10) + 1;
                            num2 = rand1.nextInt(10) + 1;
                        }else {
                            num1 = rand1.nextInt(10)+1;
                            num2 = rand2.nextInt(10)+1;
                        }
                        break;
                    case  2:

                        temp = rand1.nextInt(100)+1;
                        if(temp<rand2.nextInt(100)+1) {
                            num1 = rand2.nextInt(100) + 1;
                            num2 = rand1.nextInt(100) + 1;
                        }else {
                            num1 = rand1.nextInt(100)+1;
                            num2 = rand2.nextInt(100)+1;
                        }
                        break;
                    case 3:
                        temp = rand1.nextInt(100)+1;
                        if(temp<rand2.nextInt(1000)+1) {
                            num1 = rand2.nextInt(1000) + 1;
                            num2 = rand1.nextInt(1000) + 1;
                        }else {
                            num1 = rand1.nextInt(1000)+1;
                            num2 = rand2.nextInt(1000)+1;
                        }
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void setEvenclickview (){
        btnAdd.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnMul.setOnClickListener(this);
        btnDiv.setOnClickListener(this);

        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);

        btnc.setOnClickListener(this);
        btnBack.setOnClickListener(this);
        btnEnter.setOnClickListener(this);
        btnExit.setOnClickListener(this);
        btnNext.setOnClickListener(this);

    }
    public void init(){
        Typeface customfont = Typeface.createFromAsset(getAssets(),"fonts/Jokerman-Regular.ttf");
        studentinfo = (TextView) findViewById(R.id.st_info);
        studentinfo.setTypeface(customfont);
        tvstatus = (TextView) findViewById(R.id.tv_status);
        tvstatus.setTypeface(customfont);
        spnLevel = (Spinner) findViewById(R.id.spn_level);
        tvnumber1 = (TextView) findViewById(R.id.tv_number1);
        tvnumber1.setTypeface(customfont);
        tvnumber2 = (TextView) findViewById(R.id.tv_number2);
        tvnumber2.setTypeface(customfont);
        tvresult = (TextView) findViewById(R.id.tv_result);
        tvresult.setTypeface(customfont);
        tvattempt = (TextView) findViewById(R.id.tv_attempt);
        tvattempt.setTypeface(customfont);
        tvcorrect = (TextView) findViewById(R.id.tv_correct);
        tvcorrect.setTypeface(customfont);
        tvaccurate = (TextView) findViewById(R.id.tv_accurate);
        tvaccurate.setTypeface(customfont);
        tvChooselv = (TextView) findViewById(R.id.tv_chooselv);
       // tvChooselv.setTypeface(customfont);
        tvChooseoptor = (TextView) findViewById(R.id.tv_chooseoptor);
        tvChooseoptor.setTypeface(customfont);
        tvoparator = (TextView) findViewById(R.id.tv_operator);
        lbAttempt = (TextView) findViewById(R.id.lb_attempt);
        lbAttempt.setTypeface(customfont);
        lbCorrect = (TextView) findViewById(R.id.lb_correct);
        lbCorrect.setTypeface(customfont);
        lbAccurate = (TextView) findViewById(R.id.lb_accurate);
        lbAccurate.setTypeface(customfont);
        btnAdd = (Button) findViewById(R.id.btn_add);
        btnSub = (Button) findViewById(R.id.btn_sub);
        btnMul = (Button) findViewById(R.id.btn_mul);
        btnDiv = (Button) findViewById(R.id.btn_div);
        btn0 = (Button) findViewById(R.id.btn_0);
        btn0.setTypeface(customfont);
        btn1 = (Button) findViewById(R.id.btn_1);
        btn1.setTypeface(customfont);
        btn2 = (Button) findViewById(R.id.btn_2);
        btn2.setTypeface(customfont);
        btn3 = (Button) findViewById(R.id.btn_3);
        btn3.setTypeface(customfont);
        btn4 = (Button) findViewById(R.id.btn_4);
        btn4.setTypeface(customfont);
        btn5 = (Button) findViewById(R.id.btn_5);
        btn5.setTypeface(customfont);
        btn6 = (Button) findViewById(R.id.btn_6);
        btn6.setTypeface(customfont);
        btn7 = (Button) findViewById(R.id.btn_7);
        btn7.setTypeface(customfont);
        btn8 = (Button) findViewById(R.id.btn_8);
        btn8.setTypeface(customfont);
        btn9 = (Button) findViewById(R.id.btn_9);
        btn9.setTypeface(customfont);
        btnc = (Button) findViewById(R.id.btn_C);
        btnc.setTypeface(customfont);
        btnBack = (Button) findViewById(R.id.btn_back);
        btnBack.setTypeface(customfont);
        btnEnter = (Button) findViewById(R.id.btn_enter);
        btnEnter.setTypeface(customfont);
        btnExit = (Button) findViewById(R.id.btn_exit);
        btnExit.setTypeface(customfont);
        btnNext = (Button) findViewById(R.id.btn_next);
        btnNext.setTypeface(customfont);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_add:
                if(selected!=0) {
                    tvoparator.setText("+");
                    tvnumber1.setText(String.valueOf(num1));
                    tvnumber2.setText(String.valueOf(num2));
                    numbercount++;
                }else
                    Toast.makeText(this, "Please,Choose your level", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_sub:
                if(selected!=0) {
                    tvoparator.setText("-");
                    tvnumber1.setText(String.valueOf(num1));
                    tvnumber2.setText(String.valueOf(num2));
                    numbercount++;
                }else
                    Toast.makeText(this, "Please,Choose your level", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_mul:
                if(selected!=0){
                    tvoparator.setText("*");
                    tvnumber1.setText(String.valueOf(num1));
                    tvnumber2.setText(String.valueOf(num2));
                    numbercount++;
                }else
                    Toast.makeText(this, "Please,Choose your level", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_div:
                if(selected!=0) {
                    tvoparator.setText("/");
                    tvnumber1.setText(String.valueOf(num1));
                    tvnumber2.setText(String.valueOf(num2));
                    numbercount++;
                }else
                    Toast.makeText(this, "Please,Choose your level", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_0:
                tvresult.append("0");
                break;
            case R.id.btn_1:
                tvresult.append("1");
                break;
            case R.id.btn_2:
                tvresult.append("2");
                break;
            case R.id.btn_3:
                tvresult.append("3");
                break;
            case R.id.btn_4:
                tvresult.append("4");
                break;
            case R.id.btn_5:
                tvresult.append("5");
                break;
            case R.id.btn_6:
                tvresult.append("6");
                break;
            case R.id.btn_7:
                tvresult.append("7");
                break;
            case R.id.btn_8:
                tvresult.append("8");
                break;
            case R.id.btn_9:
                tvresult.append("9");
                break;
            case R.id.btn_C:
                tvresult.append("-");
                break;
            case R.id.btn_next:
                tvresult.setText("");
                tvstatus.setText("");
                int temp;
                if(selected ==1){

                    temp = rand1.nextInt(10)+1;
                    if(temp<rand2.nextInt(10)+1) {
                        num1 = rand2.nextInt(10) + 1;
                        num2 = rand1.nextInt(10) + 1;
                    }else {
                        num1 = rand1.nextInt(10)+1;
                        num2 = rand2.nextInt(10)+1;
                    }
                    tvnumber1.setText(String.valueOf(num1));
                    tvnumber2.setText(String.valueOf(num2));
                    numbercount++;
                }
                if(selected ==2){

                    temp = rand1.nextInt(100)+1;
                    if(temp<rand2.nextInt(100)+1) {
                        num1 = rand2.nextInt(100) + 1;
                        num2 = rand1.nextInt(100) + 1;
                    }else {
                        num1 = rand1.nextInt(100)+1;
                        num2 = rand2.nextInt(100)+1;
                    }
                    tvnumber1.setText(String.valueOf(num1));
                    tvnumber2.setText(String.valueOf(num2));
                    numbercount++;
                }
                if(selected==3){
                    temp = rand1.nextInt(1000)+1;
                    if(temp<rand2.nextInt(1000)+1) {
                        num1 = rand2.nextInt(1000) + 1;
                        num2 = rand1.nextInt(1000) + 1;
                    }else {
                        num1 = rand1.nextInt(1000)+1;
                        num2 = rand2.nextInt(1000)+1;
                    }
                    tvnumber1.setText(String.valueOf(num1));
                    tvnumber2.setText(String.valueOf(num2));
                    numbercount++;
                }
                break;
            case R.id.btn_back:
//                String numberAfterremove= DelAnum(tvresult.getText().toString());
//                tvresult.setText(numberAfterremove);
                BaseInputConnection tvInputconnection = new BaseInputConnection(tvresult,true);
                tvInputconnection.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN,KeyEvent.KEYCODE_DEL));
                break;
            case R.id.btn_enter:
               String choice = (String) tvoparator.getText();
                DecimalFormat df = new DecimalFormat("###.#####");
                double num1 = Double.parseDouble(String.valueOf(tvnumber1.getText()));
                double num2 = Double.parseDouble(String.valueOf(tvnumber2.getText()));
               double result = 0.0;
             switch (choice){
                    case "+":
                        result = num1 + num2;
                        break;
                    case "-":
                        result = num1 - num2;
                        break;
                    case"*":
                        result = num1*num2;
                        break;
                    case "/":
                        result = num1/num2;
                        break;
                }
                Double num3;
                try {
                    num3 = Double.parseDouble(String.valueOf(tvresult.getText()));
                
                if (num3 == result){
                    tvstatus.setText("Congratulations");
                }
                else {
                    tvstatus.setText("The correct answer is "+ df.format(result));
                    j++;
               }
                }catch (NumberFormatException ex){
                    Toast.makeText(this, "Enter your Answer", Toast.LENGTH_SHORT).show();
                    return;
                }
                tvattempt.setText(String.valueOf(numbercount));
                tvcorrect.setText(String.valueOf(numbercount-j));

                double percentage = (Double.parseDouble(tvcorrect.getText().toString())/Double.parseDouble(tvattempt.getText().toString()))*100;
                tvaccurate.setText(String.format("%.2f%%",percentage));
                break;
            case R.id.btn_exit:
                System.exit(0);
                break;
        }
    }
//    public String DelAnum(String number){
//        int lenght = number.length();
//        String temp = number.substring(0,lenght-1);
//        return temp;
//    }
}
