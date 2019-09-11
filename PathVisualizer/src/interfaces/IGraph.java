package interfaces;

public interface IGraph<V, E>
{ 	
	// Get sizes
	int numEdges();
	int numVertices();
	
	// Inspectors
	Iterable<IEdge<E>> edges();
	Iterable<IVertex<V>> vertices();
	Iterable<IEdge<E>> incidentEdges(IVertex<V> v);
	// IVertex<V> opposite(IVertex<V> v, IEdge<E> e);
	// IVertex<V>[] endVertices(IEdge<E> e);
	boolean areAdjacent(IVertex<V> u, IVertex<V> v);

	// Modifiers
	V replace(IVertex<V> v, V o);
	E replace(IEdge<E> e, E o);
	IVertex<V> insertVertex(V o);
	V removeVertex(IVertex<V> v);
	IEdge<E> insertEdge(IVertex<V> u, IVertex<V> v, E o);
	E removeEdge(IEdge<E> e);
}


