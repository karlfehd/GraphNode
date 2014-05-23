package karl;

import java.util.ArrayList;

public interface GNode {
	public String getName();

	public GNode[] getChildren();

	public void addChild(GNode n);

	public ArrayList walkGraph(GNode node);

	public ArrayList paths(GNode node);
}
