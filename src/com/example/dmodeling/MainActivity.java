package com.example.dmodeling;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;


public class MainActivity extends Activity {

	GLSurfaceView ourSurface;
	ModelRenderer ourRender;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);		
		ourSurface = new GLSurfaceView(this);
		ourRender = new ModelRenderer(this);
		ourSurface.setRenderer(ourRender);
		FrameLayout fram = (FrameLayout)findViewById(R.id.myframelayout);
		fram.addView(ourSurface);
		
	}
	
	@Override
	protected void onPause(){
		super.onPause();
		ourSurface.onPause();
	}
	
	@Override
	protected void onResume(){
		super.onResume();
		ourSurface.onResume();
	}
	
	public void onClick(View view){
        switch (view.getId()) {
	        case R.id.left:
	        	ourRender.LRRotate-=10;
	        	Log.v("button", "left");
	        	break;
	        case R.id.right:
	        	ourRender.LRRotate+=10;
	        	Log.v("button", "right");
	        	break;
	        case R.id.up:
	        	ourRender.UDRotate-=10;
	        	Log.v("button", "up");
	        	break;
	        case R.id.down:
	        	ourRender.UDRotate+=10;
	        	Log.v("button", "down");
	        	break;
	        case R.id.in:
	        	ourRender.zoom-=50;
	        	Log.v("button", "down");
	        	break;
	        case R.id.out:
	        	ourRender.zoom+=50;
	        	Log.v("button", "down");
	        	break;
	        default:
	        	break;
        }
	}
}
