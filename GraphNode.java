package karl;

import java.util.ArrayList;

public class GraphNode implements GNode {

	private String name;
	private ArrayList<GNode> children = new ArrayList<GNode>();

	public GraphNode(String n) {
		this.name = n;
	}

	public void addChild(GNode n) {
		children.add(n);
	}

	public String getName() {
		return name;
	}

	public String toString() {
		return name;
	}

	public GNode[] getChildren() {
		GNode[] tempNode = new GNode[children.size()];
		for (int i = 0; i < children.size(); i++)
			tempNode[i] = children.get(i);

		return tempNode;
	}

	public ArrayList walkGraph(GNode node) {

		ArrayList tempList = new ArrayList();
		ArrayList childList = new ArrayList();
		childList.add(node);
		GraphNode currentnode = null;

		while (!childList.isEmpty()) {

			currentnode = (GraphNode) childList.remove(0);

			if (!tempList.contains(currentnode))
				tempList.add(currentnode);

			if (currentnode.getChildren().length > 0) {

				for (int i = 0; i < currentnode.getChildren().length; i++) {

					if (!childList.contains(currentnode.getChildren()[i]))
						childList.add(currentnode.getChildren()[i]);
				}
			}

		}

		return tempList;

	}// end walkGraph

	public ArrayList<ArrayList<GNode>> paths(GNode node) {
		ArrayList<ArrayList<GNode>> tempList = new ArrayList<ArrayList<GNode>>();
		GraphNode currentnode = (GraphNode) node;

		if (currentnode.getChildren().length > 0) {
			for (GNode child : currentnode.getChildren()) {

				tempList.addAll(paths(child));

			}
			for (ArrayList<GNode> child : tempList) {
				child.add(0, currentnode);
			}

		} else {
			ArrayList<GNode> thisnode = new ArrayList<GNode>();
			thisnode.add(currentnode);
			tempList.add(thisnode);
		}

		return tempList;

	}// end paths

}// end GraphNode
