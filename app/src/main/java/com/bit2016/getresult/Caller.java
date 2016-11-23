package com.bit2016.getresult;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Caller extends AppCompatActivity {
    private static int REQUEST_CODE_CALLEEACTIVITY=1;
    private static int REQUEST_CODE_CALLEEACTIVITY2=1;
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==REQUEST_CODE_CALLEEACTIVITY){
            if(resultCode== Activity.RESULT_OK){
                int dataNumber=data.getIntExtra("data_number",0);
                String dataString=data.getStringExtra("data_string");

                String result="data_number:"+dataNumber+"date_string:"+dataString;
                TextView textView=(TextView)findViewById(R.id.textView_result);
                textView.setText(result);


            }
        }else if(requestCode==REQUEST_CODE_CALLEEACTIVITY2){

        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caller);

        findViewById(R.id.button_call).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Caller.this,Callee.class);
                startActivityForResult(intent,REQUEST_CODE_CALLEEACTIVITY);

            }
        });



    }
}
