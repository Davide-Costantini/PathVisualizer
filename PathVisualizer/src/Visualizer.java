import java.util.ArrayList;
import graph.Graph;
import graphics.Color;
import graphics.Rectangle;
import graphics.Text;

public class Visualizer {

	public static void main(String[] args) throws InterruptedException {

		int width = 50; // Number of rectangles per row
		int height = 25; // Number of rectangles per column
		int side = 20; // Side length of each rectangle
		int offset = 2; // Space between each rectangle
		int heightUpperBlankSpace = 55;

		Text menu = new Text(0, 0, "Here goes the menu");
		menu.setColor(Color.BLUE);
		menu.draw();

		ArrayList<Rectangle> board = Utilities.setUpBoard(width, height, side, offset, heightUpperBlankSpace);
		Graph<String> graph = Utilities.setUpGraph(width, height);
		Utilities.removeVertexAndColor(board, graph, width, height);
		Pathfinding.depthFirstSearch(graph, graph.vertices().get(490), board);

	}

}
