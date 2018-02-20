package com.androidfromhome.expandablelist;

import java.util.ArrayList;
import java.util.HashMap;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.Toast;

public class ExpandableListActivity extends Activity {

	private ExpandableListView elv_android;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_expandable_list);
		
		
		elv_android=(ExpandableListView)findViewById(R.id.elv_android);
		elv_android.setGroupIndicator(null);
		
		ExpandableCollection.key_value=new ArrayList<String>();
		ExpandableCollection.expandable_main_arr=new ArrayList<ExpandableCollection>();
		ExpandableCollection.expandable_hashmap=new HashMap<String,ArrayList<ExpandableCollection>>();
		
				
		ExpandableCollection.key_value.add("Insect");
		ExpandableCollection.key_value.add("Natural");
		ExpandableCollection.key_value.add("Environment");
		
		
		ArrayList<ExpandableCollection> arr_obj1=new ArrayList<ExpandableCollection>();
		
		arr_obj1.add(new ExpandableCollection("Butterfly", "Butterflies are " +
				"part of the class of Insects in the order Lepidoptera", R.drawable.butterfly));
		ExpandableCollection.expandable_hashmap.put(ExpandableCollection.key_value.get(0), arr_obj1);
		
		
		ArrayList<ExpandableCollection> arr_obj2=new ArrayList<ExpandableCollection>();
		
		arr_obj2.add(new ExpandableCollection("Green Scenery", "Green Scenery " +
				"is good for health", R.drawable.green_scenery));
		arr_obj2.add(new ExpandableCollection("Leaf", "A leaf is an organ " +
				"of a vascular plant and is the principal lateral appendage of the stem.", R.drawable.leaf));
		arr_obj2.add(new ExpandableCollection("One Rose", "A rose is a woody perennial " +
				"of the genus Rosa, within the family Rosaceae", R.drawable.one_rose));
		ExpandableCollection.expandable_hashmap.put(ExpandableCollection.key_value.get(1), arr_obj2);
		
		
		ArrayList<ExpandableCollection> arr_obj3=new ArrayList<ExpandableCollection>();
		
		arr_obj3.add(new ExpandableCollection("Open Sky", "The sky (or celestial dome) is everything that lies above the surface of " +
				"the Earth, including the atmosphere and outer space.", R.drawable.sky));
		
		ExpandableCollection.expandable_hashmap.put(ExpandableCollection.key_value.get(2), arr_obj3);
		
		
		
		
		AndroidExpandableListAdapter adapter=new AndroidExpandableListAdapter(ExpandableListActivity.this, ExpandableListActivity.this,
				ExpandableCollection.key_value, 
				ExpandableCollection.expandable_hashmap);
		
		elv_android.setAdapter(adapter);
		
		elv_android.setOnChildClickListener(new OnChildClickListener() {

			@Override
			public boolean onChildClick(ExpandableListView parent, View v,
					int groupPosition, int childPosition, long id) {
				
					if (ExpandableCollection.key_value!=null) {
					if (ExpandableCollection.key_value.size()>groupPosition) {
						String key=ExpandableCollection.key_value.get(groupPosition);
					
						if (ExpandableCollection.expandable_hashmap.size()>0) {
							ExpandableCollection obj_exp	=ExpandableCollection.expandable_hashmap
							.get(key).get(childPosition);
							
							Toast.makeText(ExpandableListActivity.this, "Details :"+obj_exp.message,
									Toast.LENGTH_LONG).show();
						}}}
					return false;}
		});
	}

	
}
