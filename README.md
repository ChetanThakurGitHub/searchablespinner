# Searchablespinner with model type

Searchable spinner with model type and also use shot list.

![1](https://user-images.githubusercontent.com/38001516/44401369-101a2500-a56c-11e8-85b2-8abb3dd46709.png)   ![2](https://user-images.githubusercontent.com/38001516/44401367-0f818e80-a56c-11e8-9718-6dd4c721c37e.png)

# Implementation Guide :

Adding Searchablespinner dependency in build.gradle (Module: app)
```
dependencies {
    // Searchablespinner
    implementation 'com.chetan.thakur:SearchSpinner-ModelType:1.0.0'
}
```

# Implementation Guide in Activity :

## Adding in your Activity XML

<!-- Searchablespinner activity -->
```
   <?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context="com.chetan.thakur.searchablespinner.MainActivity">

    <RelativeLayout
        android:id="@+id/layout_for_aofs"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_gravity="center"
        android:padding="@dimen/_10sdp"
        tools:ignore="UselessParent">

        <android.support.v7.widget.AppCompatImageView
            android:id="@+id/image2"
            android:layout_width="@dimen/_20sdp"
            android:layout_height="@dimen/_20sdp"
            android:padding="@dimen/_3sdp"
            android:layout_centerVertical="true"
            app:srcCompat="@drawable/ic_down_arrow"
            android:layout_alignParentRight="true"
            android:layout_alignParentEnd="true" />

        <TextView
            android:id="@+id/tvAofs"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_gravity="center"
            android:textSize="@dimen/_12sdp"
            android:singleLine="true"
            android:ellipsize="end"
            android:textColorHint="@color/lightgray"
            android:textColor="@color/darkgray"
            android:layout_marginTop="@dimen/_5sdp"
            android:layout_marginBottom="@dimen/_5sdp"
            android:layout_marginLeft="@dimen/_5sdp"
            android:hint="@string/area_of_specialtys"
            android:layout_toLeftOf="@+id/image2"
            android:layout_marginStart="@dimen/_5sdp"
            android:layout_toStartOf="@+id/image2" />

    </RelativeLayout>

</LinearLayout>
```

## Searchablespinner in Activity
```
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

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
```
