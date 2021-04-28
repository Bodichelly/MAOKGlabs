import javax.media.j3d.BranchGroup;
import com.sun.j3d.utils.geometry.ColorCube;
import com.sun.j3d.utils.universe.SimpleUniverse;

public class RedCube {

	public static void main(String[] args) {
		new RedCube();
	}

	public RedCube()

	{
		// ��������� ������, � ����� ������ ���������
		SimpleUniverse universe = new SimpleUniverse();
		// ��������� �����, � ��� ������ ��'���� ��� �����������
		BranchGroup group = new BranchGroup();
		// ������ � ����� ��� � ��������, �� ������� 0.3 �� ������ ����
		group.addChild(new ColorCube(0.3));
		// ������������ ����� ��������� �� �����������
		universe.getViewingPlatform().setNominalViewingTransform();
		// ������ �������� ����� � ������
		universe.addBranchGraph(group);
	}
}
