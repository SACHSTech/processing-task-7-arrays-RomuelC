import processing.core.PApplet;

public class Sketch extends PApplet {

	float[] circleY = new float[25];

  int num = 50;
  int[] x = new int[num];
  int[] y = new int[num];
	
  public void settings() {
    size(400, 400);

    for (int i = 0; i < circleY.length; i++) {
      circleY[i] = random(height);
    }
          for (int p = num-1; p > 0; p--) {
            x[p] = x[p-1];
            y[p] = y[p-1];
          }
  
          x[0] = mouseX;
          y[0] = mouseY;    
  }

 
  public void setup() {
    background(210, 255, 173);

    size(100, 100);
    noStroke();
    fill(255, 102);
    background(0);
  }

  public void draw() {

    background(50);

    for (int i = 0; i < circleY.length; i++) {
      float circleX = width * i / circleY.length;
      ellipse(circleX, circleY[i], 25, 25);
  
      circleY[i] ++;
  
      if (circleY[i] > height) {
        circleY[i] = 0;

    for (int p = 0; p < num; p++) {
      ellipse(x[p], y[p], p/ (float) 2.0, p/ (float) 2.0);          
          }
      }
          
  }
}
}