import java.util.ArrayList;


public interface GNode {
	public String getName();
    public GNode[] getChildren();
    public ArrayList walkGraph(GNode node);
    public ArrayList paths(GNode node);
}
