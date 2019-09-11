
public class Vertex {

	// Pointer to itself
	private Vertex thisVertex;

	public Vertex(Vertex thisVertex) {

		this.thisVertex = thisVertex;

	}

	public Vertex element() {
		return thisVertex;
	}

}
