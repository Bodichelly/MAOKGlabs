import java.awt.Container;

import javax.media.j3d.AmbientLight;
import javax.media.j3d.Appearance;
import javax.media.j3d.BoundingSphere;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.DirectionalLight;
import javax.media.j3d.Material;
import javax.media.j3d.Texture;
import javax.media.j3d.TextureAttributes;
import javax.vecmath.Color3f;
import javax.vecmath.Color4f;
import javax.vecmath.Point3d;
import javax.vecmath.Vector3f;

import com.sun.j3d.utils.geometry.Primitive;
import com.sun.j3d.utils.geometry.Sphere;
import com.sun.j3d.utils.image.TextureLoader;
import com.sun.j3d.utils.universe.SimpleUniverse;

public class AppearenceSphere {

	public static void main(String[] args) {
		new AppearenceSphere();
	}

	public AppearenceSphere()

	{
		SimpleUniverse universe = new SimpleUniverse();
		BranchGroup group = new BranchGroup();

		Color3f emissive = new Color3f(0.0f, 0.0f, 0.0f);
		Color3f ambient = new Color3f(0.9f, .15f, .15f);
		Color3f diffuse = new Color3f(0.7f, .15f, .15f);
		Color3f specular = new Color3f(0.0f, 0.0f, 0.0f);

		// ����������� ��������
		TextureLoader loader = new TextureLoader("C:\\2.jpg", "LUMINANCE", new Container());
		Texture texture = loader.getTexture();
		// ������ ���������� �������
		texture.setBoundaryModeS(Texture.WRAP);
		texture.setBoundaryModeT(Texture.WRAP);
		texture.setBoundaryColor(new Color4f(0.0f, 1.0f, 1.0f, 0.0f));

		// ������������ �������� ��������
		// ���� ���� REPLACE, BLEND ��� DECAL ������ MODULATE
		TextureAttributes texAttr = new TextureAttributes();
		texAttr.setTextureMode(TextureAttributes.MODULATE);

		// ��������� ����� ������
		Appearance ap = new Appearance();
		// ������ �� ������� ��������
		ap.setTexture(texture);
		ap.setTextureAttributes(texAttr);

		// ������������ �������
		ap.setMaterial(new Material(ambient, emissive, diffuse, specular, 1.0f));

		// ��������� �����, �� ��������, �� ��� ��'���� ����� ����������� ������ �� ��������� ���������
		int primflags = Primitive.GENERATE_NORMALS + Primitive.GENERATE_TEXTURE_COORDS;

		// ��������� ����, �� ��� ������ ��������� �������� �� �������
		Sphere sphere = new Sphere(0.5f, primflags, ap);
		group.addChild(sphere);

		// ��������� ��� �����
		Color3f light1Color = new Color3f(1f, 1f, 1f);
		BoundingSphere bounds =	new BoundingSphere(new Point3d(0.0, 0.0, 0.0), 100.0);
		Vector3f light1Direction = new Vector3f(4.0f, -7.0f, -12.0f);
		DirectionalLight light1	= new DirectionalLight(light1Color, light1Direction);
		light1.setInfluencingBounds(bounds);
		group.addChild(light1);
		
		// ��������� ������������ �����
		AmbientLight ambientLight =	new AmbientLight(new Color3f(.5f, .5f, .5f));
		ambientLight.setInfluencingBounds(bounds);
		group.addChild(ambientLight);

		universe.getViewingPlatform().setNominalViewingTransform();
		universe.addBranchGraph(group);
	}
}
