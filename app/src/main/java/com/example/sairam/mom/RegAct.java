package com.example.sairam.mom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class RegAct extends AppCompatActivity {

        EditText F_NAME,L_NAME;
        String fname,lname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        F_NAME=(EditText)findViewById(R.id.fmname);
        L_NAME=(EditText)findViewById(R.id.lname);
    }
    public void regonserver(View view)
    {
        fname=F_NAME.getText().toString();
        lname=L_NAME.getText().toString();
        String method="Register";
        BackGroundTask backGroundTask=new BackGroundTask(this);
        backGroundTask.execute(method,fname,lname);
        finish();
    }
}
