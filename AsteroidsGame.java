import processing.core.PApplet;
import java.util.ArrayList;
import java.util.List;
public class AsteroidsGame extends PApplet
{
    private boolean cooldown, laser;
    private int timer, score;
    Star stars;
    Spaceship s;
    List<Asteroid> aster;
    Rocket r;
    List<Bullet> gun;
    List<Powerup> pUp;
    public static void main(String[] args)
    {
        PApplet.main(new String[] {"AsteroidsGame"});
    }

    public void settings()
    {
        size(1000, 1000);
    }

    public void setup() 
    {
        s = new Spaceship(this);
        r = new Rocket(this);
        stars = new Star(this);
        aster = new ArrayList<>();
        pUp = new ArrayList<>();
        
        // Array of Asteroids
        for (int i = 0; i < 25; i++)
        {
            aster.add(i, new Asteroid(this));
        }
        // Array of Powerups
        for (int i = 0; i < 1; i++)
        {
            pUp.add(i, new Laser(this));
        }
        gun = new ArrayList<>();
        laser = false;
        timer = 600;
        score = 0;
        textSize(32);
        text("Score: 0", 20, 50);
        fill(255);
    }

    public void draw() 
    {
        background(0);
        stars.display();
        text("Score: " + score, 20, 50);
        
        // Creates powerups, asteroids, bullets, and the spaceship
        // Moves and shows the objects
        // Checks for keyboard inputs and collisions
        for (int i = 0; i < pUp.size(); i++)
        {
            pUp.get(i).show();
            pUp.get(i).move();
        }
        for (int i = 0; i < aster.size(); i++)
        {
            aster.get(i).show();
            aster.get(i).move();
        }
        checkCollision();
        s.show();
        for (int i = 0; i < gun.size(); i++)
        {
            gun.get(i).show();
            gun.get(i).move();
        }
        keyInputs();
        s.move();
        r.move();
        ability();
        
        // Removes bullets when they leave the screen
        for (int i = 0; i < gun.size(); i++)
        {
            if (gun.get(i).getX() > this.width || gun.get(i).getX() < 0 ||
            gun.get(i).getY() > this.height || gun.get(i).getY() < 0)
            {
                gun.remove(i);
            }
        }
    }

    public void keyInputs()
    {
        if (keyPressed)
        {
            if (key == CODED)
            {
                // Spaceship movement
                if (keyCode == UP)
                {
                    s.accelerate(0.15);
                    r.accelerate(0.15);
                    r.show();
                }
                else if (keyCode == DOWN)
                {
                    s.accelerate(-0.15);
                    r.accelerate(-0.15);
                }
                else if (keyCode == LEFT)
                {
                    s.rotate(-3);
                    r.rotate(-3);
                }
                else if (keyCode == RIGHT)
                {
                    s.rotate(3);
                    r.rotate(3);
                }
            }
            // Creates bullets, can hold down fire button if powerup is acquired
            else if (key == ' ')
            {
                if (cooldown)
                {
                    gun.add(new Bullet(this, s));
                    if (laser == false)
                    {
                        cooldown = false;
                    }
                }
            }
        }
        else
        {
            cooldown = true;
        }
    }

    public void keyPressed()
    {
        // Hyperspace: Sets the spaceship with a
        // random position and point direction once
        if (key == 'h')
        {
            s.setVelocityX(0);
            s.setVelocityY(0);
            r.setVelocityX(0);
            r.setVelocityY(0);
            int randX = (int)(Math.random() * 1000);
            s.setX(randX);
            r.setX(randX);
            int randY = (int)(Math.random() * 1000);
            s.setY(randY);
            r.setY(randY);
            int randDirect = (int)(Math.random() * 360);
            s.setPointDirection(randDirect);
            r.setPointDirection(randDirect);
        }
    }

    public void checkCollision()
    {
        // Collision of Asteroids and Bullets
        for (int i = 0; i < aster.size(); i++)
        {
            for (int y = 0; y < gun.size(); y++)
            {
                if (dist(gun.get(y).getX(), gun.get(y).getY(), 
                    aster.get(i).getX(), aster.get(i).getY()) < 20)
                {
                    gun.remove(y);
                    aster.remove(i);
                    score++;
                    aster.add(new Asteroid(this));
                    break;
                }
            }
        }

        // Collision of Asteroids and the Spaceship
        // Sets the spaceship to the middle when hit
        for (int i = 0; i < aster.size(); i++)
        {
            if (dist(s.getX(), s.getY(), aster.get(i).getX(), 
                aster.get(i).getY()) < 20)
            {
                background(100);
                s.setX(500);
                s.setY(500);
                r.setX(500);
                r.setY(500);
                s.setVelocityX(0);
                s.setVelocityY(0);
                r.setVelocityX(0);
                r.setVelocityY(0);
                score = 0;
            }
        }

        // Collision of Spaceship and PowerUps
        for (int i = 0; i < pUp.size(); i++)
        {
            if (dist(s.getX(), s.getY(), pUp.get(i).getX(), pUp.get(i).getY()) < 20)
            {
                if (pUp.get(i) instanceof Laser)
                {
                    pUp.remove(i);
                    laser = true;
                    break;
                }
            }
        }
    }
    
    // Sets a boolean to true if a powerup is acquired
    // Counts down timer until it reaches 0
    // and resets timer for the next powerup
    public void ability()
    {
        if (laser)
        {
            if (timer > 0)
            {
                timer--;
            }
            else if (timer <= 0)
            {
                laser = false;
                pUp.add(new Laser(this));
                timer = 600;
            }
        }
    }
}