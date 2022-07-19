package com.example.propertyinfoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import com.example.propertyinfoapp.Model.DataBaseHandler;
import com.example.propertyinfoapp.Model.Property;

import java.util.ArrayList;

public class DeletePropertyActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, View.OnClickListener  {
   private DataBaseHandler dataBaseHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_property);
        dataBaseHandler=new DataBaseHandler(DeletePropertyActivity.this);
        updateUserInterface();
    }

    private void updateUserInterface() {
        ArrayList<Property> allpropertydetails =
                dataBaseHandler.returnAllPropertyDetailsObjects();
        RelativeLayout relativeLayout = new RelativeLayout(DeletePropertyActivity.this);
        ScrollView scrollView =  new ScrollView(DeletePropertyActivity.this);
        RadioGroup radioGroup =  new RadioGroup(DeletePropertyActivity.this);
        for(Property property : allpropertydetails){
            RadioButton currentradiobutton = new RadioButton(DeletePropertyActivity.this);
            currentradiobutton.setId(property.getPropertyId());
            currentradiobutton.setText(property.toString());
            radioGroup.addView(currentradiobutton);
        }
        radioGroup.setOnCheckedChangeListener(DeletePropertyActivity.this);
        Button btnback = new Button(DeletePropertyActivity.this);
        btnback.setOnClickListener(DeletePropertyActivity.this);
        btnback.setText("Go Back");
        scrollView.addView(radioGroup);
        RelativeLayout.LayoutParams buttonParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        buttonParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        buttonParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        buttonParams.setMargins(0,0,0,70);
        relativeLayout.addView(btnback,buttonParams);
        ScrollView.LayoutParams scrollviewParams = new ScrollView.LayoutParams(
                ScrollView.LayoutParams.MATCH_PARENT,
                ScrollView.LayoutParams.MATCH_PARENT
        );
        relativeLayout.addView(scrollView,scrollviewParams);
        setContentView(relativeLayout);
    }
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        dataBaseHandler.deletePropertyDetails(checkedId);
        Toast.makeText(DeletePropertyActivity.this, "The  Property Details Is Been Deleted",
                Toast.LENGTH_SHORT).show();
        updateUserInterface();
    }
    @Override
    public void onClick(View v) {
        finish();
    }

}