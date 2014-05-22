import java.util.ArrayList;


public class GraphNode implements GNode{

	private String name;
	private ArrayList children = new ArrayList();
	boolean visited;

	public GraphNode(String n){

		this.name = n;
		this.visited = false;
	}

	public void addChild(GNode n){
		children.add(n);
	}

	public String getName() {
		return name;
	}

	public GNode[] getChildren() {
		GNode[] tempNode = new GNode[children.size()];
		for (int i=0; i < children.size(); i++)
			tempNode[i] = (GNode) children.get(i);

		return tempNode;
	}

	public ArrayList walkGraph(GNode node) {
		
		ArrayList tempList = new ArrayList();
		ArrayList childList = new ArrayList();
		GraphNode currentnode = (GraphNode) node;
		boolean childremains = true;

		while (childremains){

			if (!currentnode.visited){
				
				currentnode.visited = true;
				
				if (!tempList.contains(currentnode))
					tempList.add(currentnode);
				
				if (currentnode.getChildren().length > 0 ){
					
					for (int i=0; i < currentnode.getChildren().length; i++){
						
						if (!childList.contains(currentnode.getChildren()[i]))
							childList.add(currentnode.getChildren()[i]);
					}
				}
			}
			
			if (childList.isEmpty())
				childremains = false;
			else
				currentnode = (GraphNode) childList.remove(0);

		}

		return tempList;
	}

	public ArrayList paths(GNode node) {
		ArrayList tempList = new ArrayList();
		GraphNode currentnode = (GraphNode) node;
		String currentpath = new String(); 
				
		if (currentnode.getChildren().length > 0){
			for (int x=0; x < currentnode.getChildren().length; x++){
				currentnode.paths(currentnode.getChildren()[x]);
			}
			
			tempList.add(currentpath) ;
		}
		else
			currentpath += currentnode.getName();
	
		
		return tempList;
	}

}
