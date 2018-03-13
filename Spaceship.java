import processing.core.PApplet;
public class Spaceship extends Floater  
{
    public Spaceship(PApplet ap)
    {
        super(ap);
        corners = 4;
        xCorners = new int[corners];
        yCorners = new int[corners];
        xCorners[0] = -2;
        yCorners[0] = 0;
        xCorners[1] = -8;
        yCorners[1] = -8;
        xCorners[2] = 16;
        yCorners[2] = 0;
        xCorners[3] = -8;
        yCorners[3] = 8;
        myColor = 255;
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
}