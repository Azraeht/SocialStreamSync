package com.example.socialstreamsync;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Window;
import android.widget.Toast;

public class MainActivity extends Activity implements TabListener { 

   private ExempleFragment frag1 = new ExempleFragment();
   private ExempleFragment frag2 = new ExempleFragment(); 
   private ExempleFragment frag3 = new ExempleFragment(); 
   

   @Override
   public void onCreate(Bundle savedInstanceState) {       
      super.onCreate(savedInstanceState);             
      getWindow().requestFeature(Window.FEATURE_ACTION_BAR);       
      setContentView(R.layout.activity_main); 
 
      //configuration des ongles
      Bundle b = new Bundle(2);
      
      b.putString("name", "frag1");
      b.putInt("id", 1);
      this.frag1.setParams(b);
      
      b.putString("name", "frag2");
      b.putInt("id", 2);
      this.frag2.setParams(b);
      
      b.putString("name", "frag3");
      b.putInt("id", 3);
      this.frag3.setParams(b);
      
      //Configuration de la barre d'onglet       
      getActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
      getActionBar().addTab(getActionBar().newTab().setText(frag1.getName()).setTabListener(this));         
      getActionBar().addTab(getActionBar().newTab().setText(frag2.getName()).setTabListener(this));  
      getActionBar().addTab(getActionBar().newTab().setText(frag3.getName()).setTabListener(this));
      
   } 
   
   @Override 
   public void onTabSelected(Tab tab, android.app.FragmentTransaction ft) {
      Toast.makeText(this, tab.getText() + " selected", 
      Toast.LENGTH_SHORT).show();       

      if(tab.getText().equals(frag1.getName())){              
         ft.replace(R.id.fragmentContainer, frag1);
      }
      else if(tab.getText().equals(frag2.getName())){
         ft.replace(R.id.fragmentContainer, frag2);
      }
      else if(tab.getText().equals(frag3.getName())){ 
         ft.replace(R.id.fragmentContainer, frag3);
      }
   } 

   @Override
   public void onTabUnselected(Tab tab, android.app.FragmentTransaction ft) {
      Toast.makeText(this, tab.getText() + " unselected", 
         Toast.LENGTH_SHORT).show();       

      if(tab.getText().equals(frag1.getName())){
         ft.remove(frag1);
      }
      else if(tab.getText().equals(frag2.getName())){
         ft.remove(frag2);
      }
      else if(tab.getText().equals(frag3.getName())){
         ft.remove(frag3);
      }
   } 

   @Override
   public void onTabReselected(Tab tab, android.app.FragmentTransaction ft) {
	   Toast.makeText(this, tab.getText() + " unselected", 
	   Toast.LENGTH_SHORT).show();
   }


}