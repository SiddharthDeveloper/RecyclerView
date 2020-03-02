package com.apkglobal.recyclerview.Activites;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.apkglobal.recyclerview.R;

public class DetailsActivity extends AppCompatActivity {
   TextView detname,detdesc;
   Bundle extras;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        extras=getIntent().getExtras();

        detname=findViewById(R.id.detname);
        detdesc=findViewById(R.id.detdesc);

        if(extras!=null){

           detname.setText(extras.getString("name"));
           detdesc.setText(extras.getString("description"));
        }



    }
}
