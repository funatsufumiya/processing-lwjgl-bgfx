package test;

import processing.core.PApplet;
import processing.lwjgl.PLWJGL;
// import processing.opengl.PShader;

public class PSketch extends PApplet {
  // PShader blur;
  
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
    background(255);
    
    lights();
//    ellipse(mouseX, mouseY, 50, 50);
    
    translate(mouseX, mouseY);
    rotateX(frameCount * 0.01f);
    rotateY(frameCount * 0.01f);
    box(50);
    
    
//    filter(blur);  
//    rect(mouseX, mouseY, 150, 150); 
//    ellipse(mouseX, mouseY, 100, 100);
  }

  // static {
  //     System.setProperty("java.awt.headless", "true");
  // }
  
  public static void main(final String[] args) {    
      System.setProperty("org.lwjgl.util.Debug","true");

      PApplet.main("test.PSketch");
  }    
}
