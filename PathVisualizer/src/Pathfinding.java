import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import graph.Edge;
import graph.Graph;
import graph.Vertex;
import graphics.Color;
import graphics.Rectangle;

public class Pathfinding {

	public static void depthFirstSearch(Graph<String> g, Vertex<String> s, ArrayList<Rectangle> board)
			throws InterruptedException {

		s.setExplored();
		visit(board, s);
		Thread.sleep(5);
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

	public static void breadthFirstSearch(Graph<String> g, Vertex<String> s, ArrayList<Rectangle> board)
			throws InterruptedException {

		Queue<Vertex<String>> queue = new LinkedList<Vertex<String>>();
		s.setExplored();
		visit(board, s);
		Thread.sleep(5);
		queue.add(s);
		while (!queue.isEmpty()) {
			Vertex<String> vertex = queue.poll();
			for (Edge<String> edge : g.incidentEdges(vertex)) {
				Vertex<String> w = g.opposite(vertex, edge);
				if (!w.wasExplored()) {
					w.setExplored();
					visit(board, w);
					Thread.sleep(5);
					queue.add(w);
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
