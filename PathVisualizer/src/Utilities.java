import java.util.ArrayList;
import java.util.Random;

import graph.Edge;
import graph.Graph;
import graph.Vertex;
import graphics.Color;
import graphics.Rectangle;

public class Utilities {

	// Creates and draws all the rectangles
	public static ArrayList<Rectangle> setUpBoard(int width, int height, int side, int offset,
			int heightUpperBlankSpace) {
		ArrayList<Rectangle> board = new ArrayList<Rectangle>();
		for (int h = 0; h < height; h++) {
			for (int w = 0; w < width; w++) {
				board.add(new Rectangle(w * (side + offset), h * (side + offset) + heightUpperBlankSpace, side, side));
				board.get(h * width + w).draw();
			}
		}
		return board;
	}

	// Creates and connects the graph
	public static Graph<String> setUpGraph(int width, int height) {

		Graph<String> graph = new Graph<String>();
		for (int i = 0; i < height * width; i++) {
			graph.insertVertex(new Vertex<String>("" + i));
		}

		ArrayList<Vertex<String>> vertices = graph.vertices();
		for (int h = 0; h < height; h++) {
			for (int w = 0; w < width; w++) {

				if (!(h == height - 1)) {
					// Last column
					if (w == width - 1) {
						// Under
						graph.insertEdge(vertices.get(h * width + w), vertices.get(h * width + width + w),
								new Edge<String>(1));

					} else {
						// Under
						graph.insertEdge(vertices.get(h * width + w), vertices.get(h * width + width + w),
								new Edge<String>(1));

						// On the right
						graph.insertEdge(vertices.get(h * width + w), vertices.get(h * width + w + 1),
								new Edge<String>(1));

					}
				} else {// Last row
					if (!(w == width - 1)) {// Last row
						// On the right
						graph.insertEdge(vertices.get(h * width + w), vertices.get(h * width + w + 1),
								new Edge<String>(1));

					}
				}
			}
		}
		return graph;
	}

	public static ArrayList<Integer> nonRepeatingSequence(int bound, int size) {

		ArrayList<Integer> sequence = new ArrayList<Integer>();

		for (int i = 0; i < size; i++) {

			int rand = 0;
			boolean repeating = true;
			while (repeating) {
				repeating = false;
				rand = new Random().nextInt(bound);
				for (Integer integer : sequence) {
					if (integer.intValue() == rand) {
						repeating = true;
						break;
					}
				}
			}
			sequence.add(rand);
			sequence.sort(null);

		}

		return sequence;
	}

	public static ArrayList<Integer> removeVertexAndColor(ArrayList<Rectangle> board, Graph<String> graph, int width,
			int height) {

		ArrayList<Integer> verticesToRemove = Utilities.nonRepeatingSequence(width * height, width * height / 5);
		for (int i = verticesToRemove.size() - 1; i >= 0; i--) {
			int indexToRemove = verticesToRemove.get(i);
			board.get(indexToRemove).setColor(Color.BLACK);
			board.get(indexToRemove).fill();
			graph.removeVertex(graph.vertices().get(indexToRemove));

		}
		return verticesToRemove;
	}

	public static void resetBoard(ArrayList<Rectangle> board, ArrayList<Integer> verticesRemoved, Graph<String> graph) {

		for (int i = 0; i < board.size(); i++) {

			if (verticesRemoved.contains(i)) {
				board.get(i).setColor(Color.BLACK);
				board.get(i).fill();
			} else {
				board.get(i).setColor(Color.WHITE);
				board.get(i).fill();
				board.get(i).setColor(Color.BLACK);
				board.get(i).draw();
			}
		}

		for (Vertex<String> vertex : graph.vertices()) {
			vertex.setUnexplored();
		}

		for (Edge<String> edge : graph.edges()) {
			edge.setUnexplored();
		}

	}

}
