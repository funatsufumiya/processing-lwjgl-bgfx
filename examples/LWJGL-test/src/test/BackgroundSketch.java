package test;

import processing.core.PApplet;
import processing.lwjgl.PLWJGL;
// import processing.opengl.PShader;

public class BackgroundSketch extends PApplet {
  
  @Override
  public void settings() {
   size(600, 400, PLWJGL.P2D);
    // size(600, 400, PLWJGL.P3D);
//    fullScreen(PLWJGL.P3D);
  }
  
  @Override
  public void setup() {
//    blur = loadShader("blur.glsl"); 
//    stroke(255, 0, 0);
//    rectMode(CENTER);
  }
 
  @Override
  public void draw() {
    background(255, 0, 0);
  }

  // static {
  //     System.setProperty("java.awt.headless", "true");
  // }
  
  public static void main(final String[] args) {    
      System.setProperty("org.lwjgl.util.Debug","true");

      PApplet.main("test.EmptySketch");
  }    
}
