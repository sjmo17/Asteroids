import processing.core.PImage;
import processing.core.PApplet;
public class Bullet extends Floater
{
    double dRadians;
    public Bullet(PApplet app, Spaceship theShip)
    {
        super(app);
        myColor = 255;
        myCenterX = theShip.getX();
        myCenterY = theShip.getY();
        myPointDirection = theShip.getPointDirection();
        dRadians = myPointDirection * (Math.PI / 180);
        myVelocityX = 5 * Math.cos(dRadians) + theShip.getVelocityX();
        myVelocityY = 5 * Math.sin(dRadians) + theShip.getVelocityY();
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
    public void move()
    {
        //change the x and y coordinates by myVelocityX and myVelocityY       
        myCenterX += myVelocityX;    
        myCenterY += myVelocityY;
    }

    @Override
    public void show()
    {
        applet.noStroke();
        applet.ellipse((int)myCenterX, (int)myCenterY, 10, 10);
        applet.fill(myColor);
    }
}