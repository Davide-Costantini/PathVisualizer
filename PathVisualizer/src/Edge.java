
public class Edge {

	// Pointer to itself
	private Edge thisEdge;

	// Connected vertices
	private Vertex vertex1;
	private Vertex vertex2;

	// Weight of the edge
	private int weight;

	public Edge(Edge thisEdge, int weight, Vertex v1, Vertex v2) {

		this.thisEdge = thisEdge;

		this.vertex1 = v1;
		this.vertex2 = v2;

		if (weight >= 0) {
			this.weight = weight;
		} else {
			throw new InvalidWeightException();
		}

	}

	public Edge element() {
		return thisEdge;
	}

}

class InvalidWeightException extends RuntimeException {
}