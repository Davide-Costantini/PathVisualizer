import java.util.ArrayList;

import graph.Edge;
import graph.Graph;
import graph.Vertex;
import graphics.Color;
import graphics.Rectangle;

public class Pathfinding {

	public static void depthFirstSearch(Graph<String> g, Vertex<String> s, ArrayList<Rectangle> board) throws InterruptedException {

		s.setExplored();
		visit(board, s);
		Thread.sleep(10);
		ArrayList<Edge<String>> edges = g.incidentEdges(s);
		for (Edge<String> edge : edges) {
			if (!edge.wasExplored()) {
				edge.setExplored();
				Vertex<String> w = g.opposite(s, edge);
				if (!w.wasExplored()) {
					depthFirstSearch(g, w, board);
				}
			}
		}

	}

	private static void visit(ArrayList<Rectangle> board, Vertex<String> s) {

		int numRect = Integer.valueOf(s.element());
		board.get(numRect).setColor(Color.BLACK);
		board.get(numRect).fill();
		
	}

}
