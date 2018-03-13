import processing.core.PApplet;
public class Asteroid extends Floater
{
    private int rotationSpeed;
    public Asteroid(PApplet ap)
    {
        super(ap);
        rotationSpeed = ((int)(Math.random() * 11)) - 5;
        corners = 6;
        xCorners = new int[corners];
        yCorners = new int[corners];
        xCorners[0] = -11;
        yCorners[0] = -8;
        xCorners[1] = 7;
        yCorners[1] = -8;
        xCorners[2] = 13;
        yCorners[2] = 0;
        xCorners[3] = 6;
        yCorners[3] = 10;
        xCorners[4] = -11;
        yCorners[4] = 8;
        xCorners[5] = -5;
        yCorners[5] = 0;
        myColor = 125;
        myCenterX = (int)(Math.random()* 1000); 
        myCenterY = (int)(Math.random()* 1000);
        myVelocityX = (Math.random() * 2) - 1;
        myVelocityY = (Math.random() * 2) - 1;
        myPointDirection = 0;
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
    
    public void move()
    {
        super.move();
        myPointDirection += rotationSpeed;
    }
}