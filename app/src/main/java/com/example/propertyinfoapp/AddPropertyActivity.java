package com.example.propertyinfoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.propertyinfoapp.Model.DataBaseHandler;
import com.example.propertyinfoapp.Model.Property;

public class AddPropertyActivity extends AppCompatActivity implements View.OnClickListener{
    EditText edtname,edtprice,edtarea,edtseventwelve;
    Button addbtn,backbtn;
    DataBaseHandler dataBaseHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_property);
        edtname = findViewById(R.id.edtName);
        edtprice = findViewById(R.id.edtPrice);
        edtarea = findViewById(R.id.edtArea);
        edtseventwelve = findViewById(R.id.edtSevenTwelve);
        addbtn=findViewById(R.id.btnadddata);
        backbtn=findViewById(R.id.btnback);
        dataBaseHandler=new DataBaseHandler(AddPropertyActivity.this);
        addbtn.setOnClickListener(AddPropertyActivity.this);
        backbtn.setOnClickListener(AddPropertyActivity.this);

    }
    private void addPropertyDetailsToDataBase(){
        String namevalue=edtname.getText().toString();
        String pricevalue=edtprice.getText().toString();
        String areavalue=edtarea.getText().toString();
        String seventwelvevalue=edtseventwelve.getText().toString();
        try{
            double priceDoubleValue = Double.parseDouble(pricevalue);
            Property propertydetailsobject = new Property(0,namevalue,priceDoubleValue,areavalue,seventwelvevalue);
            dataBaseHandler.createPropertyDeatils(propertydetailsobject);
            Toast.makeText(AddPropertyActivity.this,
                      propertydetailsobject + " Property Details Are Been Added ", Toast.LENGTH_SHORT).show();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void onClick(View view){
        switch(view.getId()) {
            case R.id.btnadddata:
                addPropertyDetailsToDataBase();
                break;
            case R.id.btnback:
                this.finish();
                break;
        }
    }
}