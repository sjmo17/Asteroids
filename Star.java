import processing.core.PImage;
import processing.core.PApplet;
public class Star extends PApplet
{
    private PApplet applet;
    private int[] starsX, starsY;
    public Star(PApplet applet_)
    {
        applet = applet_;
        int number = (int)(Math.random() * 100) + 50;
        starsX = new int[number];
        starsY = new int[number];
        for (int i = 0; i < starsX.length; i++)
        {
            starsX[i] = (int)(Math.random() * 1000);
            starsY[i] = (int)(Math.random() * 1000);
        }
    }
    
    public void display()
    {
        for (int i = 0; i < starsX.length; i++)
        {
            applet.noStroke();
            applet.fill(255);
            applet.ellipse(starsX[i], starsY[i], 2, 2);
        }
    }
}