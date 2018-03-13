import processing.core.PImage;
import processing.core.PApplet;
public class Rocket extends Floater
{
    private int r, g, b;
    public Rocket(PApplet app)
    {
        super(app);
        corners = 4;
        xCorners = new int[corners];
        yCorners = new int[corners];
        xCorners[0] = -2;
        yCorners[0] = 0;
        xCorners[1] = -6;
        yCorners[1] = -4;
        xCorners[2] = -16;
        yCorners[2] = 0;
        xCorners[3] = -6;
        yCorners[3] = 4;
        r = 255;
        g = 255;
        r = 255;
        myCenterX = 500;
        myCenterY = 500;
        myVelocityX = 0.0;
        myVelocityY = 0.0;
        myPointDirection = 0.0;
    }

    public void setX(int x)
    {
        myCenterX = x;
    }

    public int getX()
    {
        return (int)myCenterX;
    }

    public void setY(int y)
    {
        myCenterY = y;
    }

    public int getY()
    {
        return (int)myCenterY;
    }

    public void setVelocityX(double x)
    {
        myVelocityX = x;
    }

    public double getVelocityX()
    {
        return myVelocityX;
    }

    public void setVelocityY(double y)
    {
        myVelocityY = y;
    }

    public double getVelocityY()
    {
        return myVelocityY;
    }

    public void setPointDirection(int degrees)
    {
        myPointDirection = degrees;
    }

    public double getPointDirection()
    {
        return myPointDirection;
    }

    @Override
    public void show ()  //Draws the floater at the current position  
    {             
        applet.fill(r, g, b);   
        applet.noStroke();  
        //convert degrees to radians for sin and cos         
        double dRadians = myPointDirection * (Math.PI / 180);                 
        int xRotatedTranslated, yRotatedTranslated;    
        applet.beginShape();         
        for(int nI = 0; nI < corners; nI++)    
        {     
            //rotate and translate the coordinates of the floater using current direction 
            xRotatedTranslated = (int)((xCorners[nI] * Math.cos(dRadians)) - (yCorners[nI] * Math.sin(dRadians)) + myCenterX);     
            yRotatedTranslated = (int)((xCorners[nI] * Math.sin(dRadians)) + (yCorners[nI] * Math.cos(dRadians)) + myCenterY);      
            applet.vertex(xRotatedTranslated, yRotatedTranslated);    
        }   
        applet.endShape(applet.CLOSE);  
    }
}