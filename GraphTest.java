package karl;

import java.util.ArrayList;

public class GraphTest {

	public static void main(String[] args) {

		GNode A = new GraphNode("A");
		GNode B = new GraphNode("B");
		GNode C = new GraphNode("C");
		GNode D = new GraphNode("D");
		GNode E = new GraphNode("E");
		GNode F = new GraphNode("F");
		GNode G = new GraphNode("G");
		GNode H = new GraphNode("H");
		GNode I = new GraphNode("I");
		GNode J = new GraphNode("J");

		A.addChild(B);
		A.addChild(C);
		A.addChild(D);
		B.addChild(E);
		B.addChild(F);
		C.addChild(G);
		C.addChild(H);
		C.addChild(I);
		D.addChild(J);

		ArrayList<ArrayList> graphA = new ArrayList<ArrayList>();
		ArrayList<ArrayList> graphB = new ArrayList<ArrayList>();
		ArrayList<ArrayList> pathA = new ArrayList<ArrayList>();
		ArrayList<ArrayList> pathB = new ArrayList<ArrayList>();

		graphA = A.walkGraph(A);
		graphB = B.walkGraph(B);
		pathA = A.paths(A);
		pathB = B.paths(B);

		System.out.println("Walk graph from node: A");
		for (int i = 0; i < graphA.size(); i++)
			System.out.print(((GNode) graphA.get(i)).getName() + " "); // Old School Print

		System.out.println("\n\nRaw Print of node: B");
		System.out.print(graphB);

		System.out.println("\n\nPath list from node: A");
		System.out.print(pathA);

		System.out.println("\n\nPath list from node: B");
		System.out.print(pathB);

	}

}
