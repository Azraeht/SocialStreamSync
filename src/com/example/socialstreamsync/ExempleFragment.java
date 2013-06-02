package com.example.socialstreamsync;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class ExempleFragment extends Fragment { 
    private String name; 
    private int id;     

    public ExempleFragment(){
    	super();
    	this.name = "Noname";
    	this.id = 99;
    }
    
    @Override 
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) { 
    
        // Inflate the layout for this fragment 
    	
        return inflater.inflate(getResources().getIdentifier("fragment" + id, "layout", container.getContext().getPackageName()), container, false); 
    }     

    public String getName() { 
        return name;
    }
    
    public Bundle getParams(){
    	Bundle b = new Bundle(2);
    	b.putString("name", this.name);
    	b.putInt("id", this.id);
    	
    	return b;
    }
    
    public void setParams(Bundle b){
    	this.name = b.getString("name");
    	this.id = b.getInt("id");
    }
   
} 
