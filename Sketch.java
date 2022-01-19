import processing.core.PApplet;

public class Sketch extends PApplet {

  public void settings() {

    size(400, 400);
  }
  // Mouse Settings
  int num = 10;
  float[] MouseX = new float[num];
  float[] MouseY = new float[num];
  int indexPosition = 0;

  // Snow Settings
  float[] snowY;
  float speed = 1;

  float[] snowPile;
  float snowHeight = height;

  

  public void setup() {

    snowY = new float [width];
    snowPile = new float[width];
    background(0);
    for(int i = 0; i < snowY.length; i++){
      snowY[i] = random(0, height);
    }
  }


  public void draw() {

    // Snow Falling Down
    background(0);
    fill(255);

    for(int i = 0; i < snowY.length; i++){
      ellipse(i * 2, snowY[i], width / 30, height / 30);
      snowY[i] += speed;

      if(snowY[i] > height){
        snowY[i] = 0;
        snowPile[i] += (width / 40);
      }
    }

    // Snow Piling Up

    for(int i = 0; i < snowPile.length; i++){
      rect(i * 2, height - snowPile[i], width / 30, height);
    }

    

    // Shifting the values to the right
    noStroke();
    for (int i = MouseX.length - 1; i > 0; i--) {
      MouseX[i] = MouseX[i - 1];
      MouseY[i] = MouseY[i - 1];
    }

    // Add the new values to the beginning of the array
    MouseX[0] = mouseX;
    MouseY[0] = mouseY;

    // Cursor Circles / Trails
    for (int i = 0; i < MouseX.length; i++) {
      tint(255, 128);
      ellipse(MouseX[i], MouseY[i], 30 - i, 30 - i);
        }

  }
  
  public void keyPressed(){
    if(keyCode == UP){
      speed += (float) (1.5);
    }
    else if (keyCode == DOWN && speed > 3){
      speed -= (float) (1.5);
    }
  }
}