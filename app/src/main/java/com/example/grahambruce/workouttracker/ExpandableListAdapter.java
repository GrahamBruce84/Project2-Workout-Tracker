package com.example.grahambruce.workouttracker;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

/**
 * Created by grahambruce on 07/07/2017.
 */

public class ExpandableListAdapter extends BaseExpandableListAdapter {

    private Context context;
    private List<String> listDataHeader;
    private HashMap<String, List<Workout>> listHashMap;

    public ExpandableListAdapter(Context context, List<String> listDataHeader, HashMap<String, List<Workout>> listHashMap) {
        this.context = context;
        this.listDataHeader = listDataHeader;
        this.listHashMap = listHashMap;
    }

    @Override
    public int getGroupCount() {
        return listDataHeader.size();
    }

    @Override
    public int getChildrenCount(int item) {
        return listHashMap.get(listDataHeader.get(item)).size();
    }

    @Override
    public Object getGroup(int item) {
        return listDataHeader.get(item);
    }

    @Override
    public Object getChild(int item, int item1) {
        return listHashMap.get(listDataHeader.get(item)).get(item1); // i == group item, i1 = child item
    }

    @Override
    public long getGroupId(int item) {
        return item;
    }

    @Override
    public long getChildId(int item, int item1) {
        return item1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int item, boolean b, View view, ViewGroup viewGroup) {
        String headerTitle = (String) getGroup(item);
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.list_group, null);
        }
        TextView lblListHeader = (TextView) view.findViewById(R.id.lblListHeader);
        lblListHeader.setTypeface(null, Typeface.BOLD);
        lblListHeader.setText(headerTitle);
        return view;
    }

    @Override
    public View getChildView(int item, int item1, boolean b, View view, ViewGroup viewGroup) {
        final Workout childWorkout = (Workout) getChild(item, item1);
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.list_item, null);
        }

        TextView txtListChild = (TextView)view.findViewById(R.id.lblListItem);
        txtListChild.setText(childWorkout.getName());

        view.setTag(childWorkout);

        return view;
    }

    @Override
    public boolean isChildSelectable(int item, int item1) {
        return true;
    }
}
