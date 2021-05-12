package sample;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.media.j3d.*;
import javax.swing.Timer;
import javax.vecmath.*;

public class Controller implements ActionListener, KeyListener {
    private TransformGroup bear;
    private Transform3D transform3D = new Transform3D();

    private float x = 0;
    private float y = 0;

    private boolean w = false;
    private boolean s = false;
    private boolean a = false;
    private boolean d = false;
    private boolean e = false;
    private boolean q = false;

    private boolean z = false;
    private boolean _x = false;

    Controller(TransformGroup bear) {
        this.bear = bear;
        this.bear.getTransform(this.transform3D);
        Timer timer = new Timer(20, this);
        timer.start();
    }

    private void Move() {
        if (w) {
            y += 0.02f;
            if (y > 0.2f) y = 0.2f;
        }
        if (s) {
            y -= 0.02f;
            if (y < -0.3f) y = -0.3f;
        }
        if (a) {
            x -= 0.02f;
            if (x < -0.8f) x = -0.8f;
        }
        if (d) {
            x += 0.02f;
            if (x > 0.8f) x = 0.8f;
        }
        transform3D.setTranslation(new Vector3f(x, y, 0));
        if (e) {
            Transform3D rotation = new Transform3D();
            rotation.rotY(0.05f);
            transform3D.mul(rotation);
        }
        if (q) {

            Transform3D rotation = new Transform3D();
            rotation.rotY(-0.05f);
            transform3D.mul(rotation);
        }
        if (z) {
            Transform3D rotation = new Transform3D();
            rotation.rotX(0.05f);
            transform3D.mul(rotation);
        }
        if (_x) {

            Transform3D rotation = new Transform3D();
            rotation.rotX(-0.05f);
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
            case 'e':
                e = true;
                break;
            case 'q':
                q = true;
                break;
            case 'z':
                z = true;
                break;
            case 'x':
                _x = true;
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
            case 'e':
                e = false;
                break;
            case 'q':
                q = false;
                break;
            case 'z':
                z = false;
                break;
            case 'x':
                _x = false;
                break;
        }
    }
}