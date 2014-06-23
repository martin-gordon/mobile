package com.example.tabapp;

import java.util.ArrayList;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.AsyncTask;
import android.view.View;


public class DrawAsync extends AsyncTask<Void, Void, ArrayList<String>>{

	private Canvas canvas;
	private View view;
	private Paint mPaint = new Paint();
	private Bitmap mBitmap = null;
	
	public DrawAsync(Canvas map, View v){
		this.canvas = map;
		this.view = v;
	}
	
	@Override
	protected ArrayList<String> doInBackground(Void... params) {
		// TODO Auto-generated method stub
		canvas.drawPaint(mPaint);
        mBitmap = BitmapFactory.decodeResource(view.getResources(), R.drawable.mymap);
        canvas.drawBitmap(mBitmap,0, 0,mPaint);
        
        mBitmap = BitmapFactory.decodeResource(view.getResources(), R.drawable.compass);
        canvas.drawBitmap(mBitmap,(view.getWidth()/2) -(mBitmap.getWidth()/2),(view.getHeight()/2) - (mBitmap.getHeight()/2), mPaint);
        
        if (GlobalParams.getInstance().getEenemy() == true){
        	mBitmap = BitmapFactory.decodeResource(view.getResources(), R.drawable.red_little);
        }
        if (GlobalParams.getInstance().getFriend() == true)
        {
        	mBitmap = BitmapFactory.decodeResource(view.getResources(), R.drawable.blue_little);
        
        for (Friend iterable : GlobalParams.getInstance().getFriends()) {

			canvas.drawBitmap(mBitmap, iterable.getWidth(),iterable.getHeight(), mPaint);
	//		iterable.setWidth(iterable.getWidth() + 1);
		
			}
        
		
	}
		return null;

}
}
