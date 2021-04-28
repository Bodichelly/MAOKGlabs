package sample;

import com.sun.j3d.utils.geometry.Primitive;
import com.sun.j3d.utils.geometry.Cylinder;
import com.sun.j3d.utils.geometry.Box;
import com.sun.j3d.utils.image.TextureLoader;

import javax.media.j3d.*;
import javax.vecmath.*;
import java.awt.*;

public class SwingBody {

    private static String assetsDir = System.getProperty("user.dir") + "\\assets\\";
    private static int primFlags = Primitive.GENERATE_NORMALS + Primitive.GENERATE_TEXTURE_COORDS;

    public static TransformGroup getBody() {
        TransformGroup transformGroup = new TransformGroup();
        transformGroup.addChild(getSit(-0.5f));
        transformGroup.addChild(getBack(-0.4f));
        transformGroup.addChild(getArmrest(-0.42f, 0.2f));
        transformGroup.addChild(getArmrest(-0.42f, -0.2f));
        transformGroup.addChild(getRope(1.0f, 0f, 0.2f));
        transformGroup.addChild(getRope(1.0f, 0f, -0.2f));
        transformGroup.addChild(getTrunk(0.5f));
        return transformGroup;
    }

    public static TransformGroup getTrunk(float y) {
        Box trunk = new Box(0.4f, .1f, .1f, primFlags, getComponentAppearance("wood.jpg"));
        Vector3f vectorTop = new Vector3f(.0f, y, .0f);
        return getTGTemplate(trunk, vectorTop);
    }

    public static TransformGroup getRope(float h, float y, float xMove) {
        Cylinder rope = new Cylinder(0.01f, h, primFlags, getComponentAppearance("rope.jpg"));
        Vector3f vectorTop = new Vector3f(xMove, y, .0f);
        return getTGTemplate(rope, vectorTop);
    }

    public static TransformGroup getArmrest (float y, float zMove) {
        Box sit = new Box(0.01f, .08f, .1f, primFlags, getComponentAppearance("pillow.jpg"));
        Vector3f vectorTop = new Vector3f(zMove, y, 0.0f);
        return getTGTemplate(sit, vectorTop);
    }

    public static TransformGroup getBack(float y) {
        Box sit = new Box(0.2f, .1f, .01f, primFlags, getComponentAppearance("pillow.jpg"));
        Vector3f vectorTop = new Vector3f(.0f, y, .1f);
        return getTGTemplate(sit, vectorTop);
    }

    public static TransformGroup getSit(float y) {
        Box sit = new Box(0.2f, .03f, .1f, primFlags, getComponentAppearance("pillow.jpg"));
        Vector3f vectorTop = new Vector3f(.0f, y, .0f);
        return getTGTemplate(sit, vectorTop);
    }

    public static TransformGroup getTGTemplate(javax.media.j3d.Node node, Vector3f vector) {
        TransformGroup tg = new TransformGroup();
        Transform3D transformTop = new Transform3D();
        transformTop.setTranslation(vector);
        tg.setTransform(transformTop);
        tg.addChild(node);
        return tg;
    }

    private static Appearance getComponentAppearance(String resource) {
        TextureLoader loader = new TextureLoader(assetsDir + resource, new Container());
        Texture texture = loader.getTexture();
        Appearance appearance = new Appearance();
        appearance.setTexture(texture);
        return appearance;
    }
}