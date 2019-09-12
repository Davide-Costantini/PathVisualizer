import java.util.ArrayList;

import graph.Edge;
import graph.Graph;
import graph.Vertex;

public class Visualizer {

	public static void main(String[] args) {
	
		int numVertices = 4;
		
		Graph<String> graph = new Graph<String>();
		
		for(int i = 0; i < numVertices; i++) {
			graph.insertVertex(new Vertex<String>("Vertex" + i));
		}
		
		ArrayList<Vertex<String>> vertices = graph.vertices();
		
		Edge<String> e1 = new Edge<String>(1);
		Edge<String> e2 = new Edge<String>(1);
		Edge<String> e3 = new Edge<String>(1);
		Edge<String> e4 = new Edge<String>(1);
		Edge<String> e5 = new Edge<String>(1);
		Edge<String> e6 = new Edge<String>(1);
		
		graph.insertEdge(vertices.get(0), vertices.get(1), e1);
		graph.insertEdge(vertices.get(1), vertices.get(2), e2);
		graph.insertEdge(vertices.get(0), vertices.get(2), e3);
		graph.insertEdge(vertices.get(2), vertices.get(3), e4);
		graph.insertEdge(vertices.get(1), vertices.get(3), e5);
		graph.insertEdge(vertices.get(0), vertices.get(3), e6);
		
		
		System.out.println(graph.opposite(vertices.get(1), e5).element());
	}
	
}
