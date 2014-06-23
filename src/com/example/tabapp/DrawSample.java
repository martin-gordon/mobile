package com.example.tabapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.View;

public class DrawSample extends View  {
	
	private Paint mPaint = new Paint();
	private Bitmap mBitmap = null;
	 private Thread renderThread = null;
		private SurfaceHolder holder;
		volatile boolean running = false;
		private Context context;
		private int x= 0;

	public DrawSample(Context context, AttributeSet attr) { 
		super(context, attr);
		this.setLongClickable(true);
	//	resume();
		//holder = getHolder();
		this.context=context;
				
	}
//	@Override
//    public void surfaceChanged(final SurfaceHolder arg0,
//                    final int arg1, final int arg2, final int arg3) {}
//	 @Override
//     public void surfaceDestroyed(final SurfaceHolder arg0) {
//   //      GameActivity.this.running = false;
//     }
//		 @Override
//	        public void surfaceCreated( SurfaceHolder arg0) {
//	            holder = arg0;
//	        }	
		//create a paint brush
	//	mPaint = new Paint();
	//	mPaint.setColor(Color.DKGRAY);
	
//	 public void run(){
//		// System.out.println("Hello World1");
//		 while( x < 100){
//			 
//		Dr22();
//		x++;
//		 }
//	}
//	    public void resume() {
//	   // 	 System.out.println("Hello World2");
//	    	 
//			running = true;
//			renderThread = new Thread(this);
//			renderThread.start();
//		}
	 public void onDraw(Canvas canvas){
			canvas.drawPaint(mPaint);
		        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.mymap);
		        canvas.drawBitmap(mBitmap,0, 0,mPaint);
		        
		        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.compass);
		        canvas.drawBitmap(mBitmap,(getWidth()/2) -(mBitmap.getWidth()/2),(getHeight()/2) - (mBitmap.getHeight()/2), mPaint);
		        
		        if (GlobalParams.getInstance().getEenemy() == true){
		        	mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.red_little);
		        }
		        if (GlobalParams.getInstance().getFriend() == true)
		        {
		        	mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.blue_little);
		        
		        for (Friend iterable : GlobalParams.getInstance().getFriends()) {

					canvas.drawBitmap(mBitmap, iterable.getWidth(),iterable.getHeight(), mPaint);
			//		iterable.setWidth(iterable.getWidth() + 1);
				
					}
		        }
		        if(GlobalParams.getInstance().pdialog != null){
					GlobalParams.getInstance().pdialog.hide();
					}
		        
		      
	 }
	public void Dr22() {
		Canvas canvas = holder.lockCanvas();
		if( canvas != null)
		{
		canvas.drawPaint(mPaint);
    //    mPaint.setColor(Color.parseColor("#CD5C5C"));
        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.mymap);
        canvas.drawBitmap(mBitmap,0, 0,mPaint);
        if (GlobalParams.getInstance().getEenemy() == true){
        	mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.red_little);
        	canvas.drawBitmap(mBitmap,200,0, null);
        }
        if (GlobalParams.getInstance().getFriend() == true)
        {
        	mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.blue_little);
        	canvas.drawBitmap(mBitmap,0,200, mPaint);
        
        for (Friend iterable : GlobalParams.getInstance().getFriends()) {
			canvas.drawBitmap(mBitmap, iterable.getWidth(),iterable.getHeight(), mPaint);
			iterable.setWidth(iterable.getWidth() + 1);
		
			}
        }
        
        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.compass);
        canvas.drawBitmap(mBitmap,(getWidth()/2) -(mBitmap.getWidth()/2),(getHeight()/2) - (mBitmap.getHeight()/2), mPaint);
        holder.unlockCanvasAndPost(canvas);
		}
      //  canvas.drawRect(50, 50, 200, 200, mPaint);
	}
	
}
