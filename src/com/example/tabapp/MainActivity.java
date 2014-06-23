package com.example.tabapp;

import android.app.ActionBar;
import android.app.ProgressDialog;
import android.app.ActionBar.Tab;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends FragmentActivity implements ActionBar.TabListener {

	private ViewPager viewPager;
    private TabsPagerAdapter mAdapter;
    private ActionBar actionBar;
    // Tab titles
    private String[] tabs = { "Top Rated", "Games", "Movies" };
    private DialogDetails dialog = new DialogDetails();
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
//      Create some friends objects for testing
//        GlobalParams.getInstance().addFriend(new Friend("martin", 200, "crazy13", 280, 200));
//        GlobalParams.getInstance().addFriend(new Friend("second", 300, "crazy2", 50, 300));

//        if (savedInstanceState == null) {
//            getSupportFragmentManager().beginTransaction()
//                    .add(R.id.container, new PlaceholderFragment())
//                    .commit();
//        }
        
        viewPager = (ViewPager) findViewById(R.id.pager);
        actionBar = getActionBar();
        mAdapter = new TabsPagerAdapter(getSupportFragmentManager());
 
        viewPager.setAdapter(mAdapter);
      //  actionBar.setHomeButtonEnabled(false);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS); 
        
        actionBar.addTab(actionBar.newTab().setText("my first tab")
                .setTabListener(this));
        
        actionBar.addTab(actionBar.newTab().setText("my sec tab")
               .setTabListener(this));

     //   mAdapter.notifyDataSetChanged();
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
       	 
            @Override
            public void onPageSelected(int position) {
                // on changing the page
                // make respected tab selected
            //    mAdapter.notifyDataSetChanged();

                actionBar.setSelectedNavigationItem(position);
            }
         
            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }
         
            @Override
            public void onPageScrollStateChanged(int arg0) {
            }
        
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
    	
    	//SecondFragment fragment = (SecondFragment) getFragmentManager().findFragmentBy
        int id = item.getItemId();
        if (id == R.id.action_settings) {
        	dialog.show(getSupportFragmentManager(),"test");

            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
//    public static class PlaceholderFragment extends Fragment {
//
//        public PlaceholderFragment() {
//        }
//
//        @Override
//        public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                Bundle savedInstanceState) {
//            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
//            return rootView;
//        }
//    }
    @Override
    public void onTabReselected(Tab tab, FragmentTransaction ft) {
    }
 
    @Override
    public void onTabSelected(Tab tab, FragmentTransaction ft) {
        // on tab selected
        // show respected fragment view
    	if(tab.getPosition() == 0 && GlobalParams.getInstance().getView() != null)
    	{
    		GlobalParams.getInstance().pdialog =new ProgressDialog(this);
            GlobalParams.getInstance().pdialog.setMessage("Reloading targets...");
            GlobalParams.getInstance().pdialog.show(); 
    	}
    	
        viewPager.setCurrentItem(tab.getPosition());
        if (GlobalParams.getInstance().listFriends!= null){
        	GlobalParams.getInstance().listFriends.update();
        	GlobalParams.getInstance().listFriends.getView().postInvalidate();
        }
    }
 
    @Override
    public void onTabUnselected(Tab tab, FragmentTransaction ft) {}
    
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        }
    
    
}
