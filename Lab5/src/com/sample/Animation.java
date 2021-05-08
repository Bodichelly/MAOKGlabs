package sample;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.media.j3d.*;
import javax.swing.Timer;
import javax.vecmath.*;

public class Animation implements ActionListener, KeyListener {
    private TransformGroup bear;
    private Transform3D transform3D = new Transform3D();

    private float x = 0;
    private float y = 0;
    private float dx = -0.02f;
    private float leftEdge = -0.5f;
    private float rightEdge = 0.5f;
    private boolean isOnTopPart = false;

    private boolean w = false;
    private boolean s = false;
    private boolean a = false;
    private boolean d = false;


    Animation(TransformGroup bear) {
        this.bear = bear;
        this.bear.getTransform(this.transform3D);
        Timer timer = new Timer(20, this);
        timer.start();
    }

    private void Move() {
        if (a) {
            x += dx;
        }
        if (d) {
            x -= dx;
        }
        if (x > rightEdge || x < leftEdge) {
            dx = -dx;
            isOnTopPart = !isOnTopPart;
        }
        elipsCalcY();
        transform3D.setTranslation(new Vector3f(x, y, 0));
        if (w) {
            Transform3D rotation = new Transform3D();
            rotation.rotY(0.05f);
            transform3D.mul(rotation);
        }
        if (s) {

            Transform3D rotation = new Transform3D();
            rotation.rotY(-0.05f);
            transform3D.mul(rotation);
        }
        bear.setTransform(transform3D);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Move();
    }

    @Override
    public void keyPressed(KeyEvent ev) {
        switch (ev.getKeyChar()) {
            case 'w':
                w = true;
                break;
            case 's':
                s = true;
                break;
            case 'a':
                a = true;
                break;
            case 'd':
                d = true;
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent ev) {
        switch (ev.getKeyChar()) {
            case 'w':
                w = false;
                break;
            case 's':
                s = false;
                break;
            case 'a':
                a = false;
                break;
            case 'd':
                d = false;
                break;
        }
    }

    public void elipsCalcY() {
        float a = 0.5f;
        float b = 0.1f;
        if(isOnTopPart){
            y = (float)(b*Math.sqrt(1-x*x/(a*a)+0.2f));
        }else{
            y = -(float)(b*Math.sqrt(1-x*x/(a*a)+0.2f));
        }
        System.out.println(y);
    }
}