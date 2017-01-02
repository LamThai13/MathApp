package com.example.lamthai.mathapp;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvWelcom;
    Button btnnext,btncancel;
    EditText edtfirstname,edtlastname,edtid;
    ImageView img;
    public static final String BUNLE = "BUNDLE";
    public static final String STNAME = "STNAME";
    public static final String STLASTNAME = "STLASTNAME";
    public static final String STID = "STID";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        final Student student = new Student();
        btncancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });
        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                student.setFirstName(edtfirstname.getText().toString());
                student.setLastName(edtlastname.getText().toString());
                student.setId(edtid.getText().toString());
                sendbundle(student);
            }
        });
    }
    public void sendbundle(Student student){
        Intent intent = new Intent(MainActivity.this,Calculation.class);
        Bundle bundle = new Bundle();
        bundle.putString(STNAME,student.getFirstName());
        bundle.putString(STLASTNAME,student.getLastName());
        bundle.putString(STID,student.getId());
        intent.putExtra(BUNLE,bundle);
        startActivity(intent);
    }
    public void init(){
        tvWelcom = (TextView) findViewById(R.id.tv_welcome);
        Typeface customfont = Typeface.createFromAsset(getAssets(),"fonts/Jokerman-Regular.ttf");
        tvWelcom.setTypeface(customfont);
        img = (ImageView)findViewById(R.id.img);
        btnnext = (Button)findViewById(R.id.buttonnext);
        btnnext.setTypeface(customfont);
        btncancel = (Button)findViewById(R.id.buttoncancel);
        btncancel.setTypeface(customfont);
        edtfirstname = (EditText)findViewById(R.id.edtfirstname);
        edtfirstname.setTypeface(customfont);
        edtlastname = (EditText)findViewById(R.id.edtlastname);
        edtlastname.setTypeface(customfont);
        edtid = (EditText)findViewById(R.id.edtid);
        edtid.setTypeface(customfont);

    }
}
