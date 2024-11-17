package com.example.assignment_5;

import android.graphics.Color;
import android.graphics.Typeface;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.constraintlayout.helper.widget.Layer;
import androidx.constraintlayout.widget.ConstraintSet;

import java.util.ArrayList;
import java.util.HashMap;

public class MainAdapter  extends BaseExpandableListAdapter {

    ArrayList<String> listGroup;
    HashMap<String,ArrayList<String>>listchild;

    public MainAdapter(ArrayList<String> listGroup , HashMap<String , ArrayList<String>> listchild){
       this.listGroup = listGroup;
        this.listchild = listchild;


    }
    @Override
    public int getGroupCount() {
        return listGroup.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return listchild.get(listGroup.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return listGroup.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return listchild.get(listGroup.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        convertView = LayoutInflater.from(parent.getContext())
                .inflate(android.R.layout.simple_expandable_list_item_1 ,
                        parent , false);
        TextView textView = convertView.findViewById(android.R.id.text1);
        String sgroup = String.valueOf(getGroup(groupPosition));
        textView.setText(sgroup);
        textView.setTypeface(null , Typeface . BOLD);
        textView.setTextColor(Color.BLUE);


        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
       convertView = LayoutInflater.from(parent.getContext())
               .inflate(android.R.layout.simple_expandable_list_item_1
               , parent , false);
       TextView textView = convertView.findViewById(android.R.id.text1);
       String schild = String.valueOf(getChild(groupPosition,childPosition));
       textView.setText(schild);

       textView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Toast.makeText(parent.getContext() ,
                       " " + schild ,
                       Toast.LENGTH_SHORT).show() ;
           }
       });




        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
