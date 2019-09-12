package graph;

import java.util.ArrayList;

public class Edge<T> {

	// Connected vertices
	private Vertex<T> vertex1;
	private Vertex<T> vertex2;
	
	private boolean wasExplored;

	// Weight of the edge
	private int weight;

	public Edge(int weight) {

		if (weight >= 0) {
			this.weight = weight;
		} else {
			throw new InvalidWeightException();
		}

	}
	
	public boolean wasExplored() {
		return this.wasExplored;
	}

	public boolean setExplored() {
		this.wasExplored = true;
		return this.wasExplored;
	}

	public boolean setUnexplored() {
		this.wasExplored = false;
		return this.wasExplored;
	}
	
	public int getWeight() {
		return this.weight;
	}

	public void setConnectedVertices(Vertex<T> v1, Vertex<T> v2) {
		this.vertex1 = v1;
		this.vertex2 = v2;
	}

	public ArrayList<Vertex<T>> getConnectedVertices() {
		if (vertex1 != null && vertex2 != null) {
			ArrayList<Vertex<T>> connectedVertices = new ArrayList<Vertex<T>>();
			connectedVertices.add(this.vertex1);
			connectedVertices.add(this.vertex2);
			return connectedVertices;
		}
		throw new VerticesNotDefinedException();
	}

}

class InvalidWeightException extends RuntimeException {
	private static final long serialVersionUID = 1L;
}

class VerticesNotDefinedException extends RuntimeException {
	private static final long serialVersionUID = 1L;
}