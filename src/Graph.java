import java.util.ArrayList;

public class Graph {

	private Node[] nodes;
	private int nodesCount;
	private Edge[] edges;
	private int edgesCount;
	
	public Graph(Edge[] edges) {
		this.edges = edges;
		this.edgesCount = edges.length;
		this.nodesCount = countNodes(edges);
		this.nodes = new Node[this.nodesCount];
		
		for (int n = 0; n < this.nodesCount; n++) {
			this.nodes[n] = new Node();
		}
		
		for(int e = 0 ; e < this.edgesCount ; e++) {
			this.nodes[edges[e].getFrom()].getEdges().add(edges[e]);
			this.nodes[edges[e].getTo()].getEdges().add(edges[e]);
		}
	}
	
	private int countNodes(Edge[] edges) {
		int _nodesCount = 0;
		for(Edge e : edges) {
			if(e.getTo() > _nodesCount) _nodesCount = e.getTo();
			if(e.getFrom() > _nodesCount) _nodesCount = e.getFrom();
		}
		return ++_nodesCount;
	}
	
	public void shortestDistances() {
	    this.nodes[0].setDistanceFromSource(0);
	    int nextNode = 0;
	    for (int i = 0; i < this.nodes.length; i++) {
	        ArrayList<Edge> currentNodeEdges = this.nodes[nextNode].getEdges();
	   
	        for (int e = 0; e < currentNodeEdges.size(); e++) {
	          int neighbourIndex = currentNodeEdges.get(e).getNeighbour(nextNode);
	   
	          if (!this.nodes[neighbourIndex].isVisited()) {
	            int tentative = this.nodes[nextNode].getDistanceFromSource() + currentNodeEdges.get(e).getLength();
	   
	            if (tentative < nodes[neighbourIndex].getDistanceFromSource()) {
	              nodes[neighbourIndex].setDistanceFromSource(tentative);
	            }
	          }
	        }
	   
	        nodes[nextNode].setVisited(true);
	   
	        nextNode = closestNode();
	   
	     }
	}
	
	  private int closestNode() {
		    int storedNodeIndex = 0;
		    int storedDist = Integer.MAX_VALUE;
		 
		    for (int i = 0; i < this.nodes.length; i++) {
		      int currentDist = this.nodes[i].getDistanceFromSource();
		 
		      if (!this.nodes[i].isVisited() && currentDist < storedDist) {
		        storedDist = currentDist;
		        storedNodeIndex = i;
		      }
		    }
		 
		    return storedNodeIndex;
		  }
	  public void printResult() {
		    String output = "Number of nodes = " + this.nodesCount;
		    output += "\nNumber of edges = " + this.edgesCount;
		 
		    for (int i = 0; i < this.nodes.length; i++) {
		      output += ("\nThe shortest distance from node 0 to node " + i + " is " + nodes[i].getDistanceFromSource());
		    }
		 
		    System.out.println(output);
		  }
		 
		  public Node[] getNodes() {
		    return nodes;
		  }
		 
		  public int getNodesCount() {
		    return nodesCount;
		  }
		 
		  public Edge[] getEdges() {
		    return edges;
		  }
		 
		  public int getEdgesCount() {
		    return edgesCount;
		  }
}
