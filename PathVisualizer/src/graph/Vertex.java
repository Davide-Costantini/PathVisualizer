package graph;

public class Vertex {

	private boolean wasExplored;

	public Vertex(Vertex thisVertex) {
		this.wasExplored = false;
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

}
