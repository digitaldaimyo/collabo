package com.collabo.shreyas;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class ShreyasGame extends Activity implements Renderer{
	
	private GLSurfaceView glView;
	private long lastFrame;
	
	@Override
	public void onCreate(Bundle savedStateInstance){
		super.onCreate(savedStateInstance);
		setupWindow();
	}
	
	@Override
	public void onSurfaceCreated(GL10 gl, EGLConfig config) {
		lastFrame = System.nanoTime();
	}
	
	// Required to extend Activity class
	@Override
	public void onSurfaceChanged(GL10 gl, int width, int height) {	
		
	}
	
	@Override
	public void onDrawFrame(GL10 gl) {
		// Find how much time has passed since last frame, for framerate independence.
		float deltaTime = (System.nanoTime() - lastFrame)/1000000000.0f;
		lastFrame = System.nanoTime();
		
		// Drawing code.
	}
	
	@Override
	public void onResume() {
		super.onResume();
		glView.onResume();		
	}
	
	@Override
	public void onPause() {		
		super.onPause();
		glView.onPause();
	}
	
	private void setupWindow() {
		// Get rid of the top title bar.
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		// Set the activity to be fullscreen.
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		// Keep the screen lit up and keep it from going to lockscreen.
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
		
		// Create the surface view.
		glView = new GLSurfaceView(this);
		
		// Set the surface view's renderer to this activity.
		glView.setRenderer(this);
		
		// Give the view an id, so it can be called back after losing focus.
		glView.setId(1);
		
		// Set the activity to use the glView. (?)
		setContentView(glView);
	}
}
