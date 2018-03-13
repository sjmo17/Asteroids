import processing.core.PApplet;
public class Powerup extends Floater
{
    int r, g, b;
    public Powerup(PApplet app)
    {
        super(app);
        r = 0;
        g = 200;
        b = 0;
        myCenterX = (int)(Math.random() * 1000);
        myCenterY = (int)(Math.random() * 1000);
        myVelocityX = (int)(Math.random() * 5) - 2;
        myVelocityY = (int)(Math.random() * 5) - 2;
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
    
    @Override
    public void show()
    {
        applet.fill(r, g, b);
        applet.noStroke();
        applet.ellipse((int)myCenterX, (int)myCenterY, 15, 15);
    }
}