package graph;

public class Vertex<T> {

	private boolean wasExplored;
	private T data;

	public Vertex(T data) {
		this.wasExplored = false;
		this.data = data;
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
	
	public T element() {
		return data;
	}
	
	public String toString() {
		return data.toString();
	}

}
