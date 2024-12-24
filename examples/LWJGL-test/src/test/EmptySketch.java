package test;

import org.lwjgl.system.Configuration;
import org.lwjgl.system.Platform;

import codeanticode.lwjgl.PLWJGL;
import processing.core.PApplet;
// import processing.opengl.PShader;

public class EmptySketch extends PApplet {
  
  @Override
  public void settings() {
//    size(600, 400, PLWJGL.P2D);
    size(600, 400, PLWJGL.P3D);
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
    // background(255);
  }

  // static {
  //     System.setProperty("java.awt.headless", "true");
  // }
  
  public static void main(final String[] args) {    
      System.setProperty("org.lwjgl.util.Debug","true");

      // System.out.println("setting glfw_async");

      if (Platform.get() == Platform.MACOSX) {
          Configuration.GLFW_LIBRARY_NAME.set("glfw_async");
      }

      PApplet.main("test.EmptySketch");
  }    
}
