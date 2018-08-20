package com.chetan.thakur.searchablespinner.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.chetan.thakur.searchablespinner.R;
import com.chetan.thakur.searchablespinner.model.ListModel;
import com.chetan.thakur.searchablespinner.sp.OnSpinerItemClick;
import com.chetan.thakur.searchablespinner.sp.SpinnerDialog;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView tvAofs;
    private SpinnerDialog spinnerDialog;
    private ArrayList<ListModel> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        addDataInList();
    }

    private void addDataInList(){
        for (int i = 0; i < 20; i++) {
            ListModel listModel = new ListModel();
            listModel.ID = String.valueOf(i);
            listModel.Name = "Chetan Thakur "+i;
            arrayList.add(listModel);
        }
        spinnerDialog = new SpinnerDialog(this, arrayList, getString(R.string.area_of_specialtys));

        spinnerDialog.bindOnSpinerListener(new OnSpinerItemClick() {
            @Override
            public void onClick(ListModel listModel) {
                Toast.makeText(MainActivity.this, listModel.ID, Toast.LENGTH_SHORT).show();
                tvAofs.setText(listModel.Name);
            }
        });
    }

    private void initView(){
        findViewById(R.id.layout_for_aofs).setOnClickListener(this);
        tvAofs = findViewById(R.id.tvAofs);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.layout_for_aofs:
                spinnerDialog.showSpinerDialog();
                break;
        }
    }
}
