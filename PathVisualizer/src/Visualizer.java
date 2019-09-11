import java.util.ArrayList;

import graph.Edge;
import graph.Graph;
import graph.Vertex;

public class Visualizer {

	public static void main(String[] args) {
	
		int numVertices = 4;
		
		Graph graph = new Graph();
		
		ArrayList<Vertex> vertices = new ArrayList<Vertex>();
		
		for(int i = 0; i < numVertices; i++) {
			vertices.add(new Vertex());
		}
		
		for (Vertex vertex : vertices) {
			graph.insertVertex(vertex);
		}
		
		Edge e1 = new Edge(1);
		Edge e2 = new Edge(1);
		Edge e3 = new Edge(1);
		Edge e4 = new Edge(1);
		Edge e5 = new Edge(1);
		Edge e6 = new Edge(1);
		
		graph.insertEdge(vertices.get(0), vertices.get(1), e1);
		graph.insertEdge(vertices.get(1), vertices.get(2), e2);
		graph.insertEdge(vertices.get(0), vertices.get(2), e3);
		graph.insertEdge(vertices.get(2), vertices.get(3), e4);
		//graph.insertEdge(vertices.get(1), vertices.get(3), e5);
		graph.insertEdge(vertices.get(0), vertices.get(3), e6);
		
		if(graph.areAdjacent(vertices.get(1), vertices.get(3))) {
			System.out.println("Yes");
		}
		else {
			System.out.println("No");
		}
	}
	
}
