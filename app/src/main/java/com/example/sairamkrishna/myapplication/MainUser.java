package com.example.sairamkrishna.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainUser extends AppCompatActivity {
    EditText ev;
    String area_id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_user);

       Button  b1 = (Button)findViewById(R.id.button);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainUser.this, MainUserOutput.class);
                ev = (EditText) findViewById(R.id.editText);
                area_id=ev.getText().toString();
                i.putExtra("AREA_ID",area_id);
                startActivity(i);
            }
            });
    }
}
