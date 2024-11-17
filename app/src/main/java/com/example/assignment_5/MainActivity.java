package com.example.assignment_5;

import android.os.Bundle;
import android.widget.ExpandableListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    ExpandableListView expandableListView;
    ArrayList<String> listGroup = new ArrayList<>();

    HashMap<String,ArrayList<String>> listchild = new HashMap<>();

    MainAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        expandableListView = findViewById(R.id.exp_list_view);
        for(int i = 0; i<=10; i++) {
            listGroup.add("group " + i);

            ArrayList<String>arrayList = new ArrayList<>();
            for(int j = 0; j<=5; i++) {
                arrayList.add("Item " + j);

            }
               listchild.put(listGroup.get(i) , arrayList);

        }
             adapter = new MainAdapter(listGroup ,listchild);
               expandableListView.setAdapter(adapter);
    }
}