import java.util.ArrayList;


public class GraphTest {

	public static void main(String[] args) {
		
		GNode A = new GraphNode("A");
		GNode B = new GraphNode("B");
		GNode C = new GraphNode("C");
		GNode D = new GraphNode("D");
		GNode E = new GraphNode("E");
		
		((GraphNode) A).addChild(B);
		((GraphNode) B).addChild(C);
		((GraphNode) B).addChild(D);
		((GraphNode) D).addChild(E);
		
		ArrayList graph = new ArrayList();
		graph = A.walkGraph(A);
		ArrayList path = new ArrayList();
		path = A.paths(A);
		
		System.out.println("Walk graph from node: " + A.getName());
		for (int i=0; i< graph.size(); i++)
			System.out.print(((GNode) graph.get(i)).getName() + " ");
		
		System.out.println("\n\nPath list from node: " + A.getName());
		for (int j=0; j< path.size(); j++)
			for (int k=0; k< path.size(); k++)
			System.out.print(((GNode) ((ArrayList) path.get(j)).get(k)).getName() + " ");

	}

}

