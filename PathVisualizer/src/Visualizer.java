import java.util.ArrayList;

import javax.swing.JButton;
import graph.Graph;
import graphics.Canvas;
import graphics.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Visualizer {

	static boolean isDFS = false;
	static boolean isBFS = false;
	static boolean isReset = false;
	static boolean isBusy = false;

	public static void main(String[] args) throws InterruptedException {

		int width = 50; // Number of rectangles per row
		int height = 25; // Number of rectangles per column
		int side = 20; // Side length of each rectangle
		int offset = 2; // Space between each rectangle
		int heightUpperBlankSpace = 55;

		ArrayList<Rectangle> board = Utilities.setUpBoard(width, height, side, offset, heightUpperBlankSpace);
		Graph<String> graph = Utilities.setUpGraph(width, height);
		ArrayList<Integer> verticesRemoved = Utilities.removeVertexAndColor(board, graph, width, height);
		int intialPoint = graph.vertices().size() / 2;

		JButton DFSButton = new JButton("DFS");
		DFSButton.setBounds(5, 5, 100, 50);
		Canvas.getFrame().add(DFSButton);
		DFSButton.repaint();

		DFSButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!isBusy) {
					System.out.println("DFS");
					isDFS = true;
				}
			}
		});

		JButton BFSButton = new JButton("BFS");
		BFSButton.setBounds(110, 5, 100, 50);
		Canvas.getFrame().add(BFSButton);
		BFSButton.repaint();

		BFSButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!isBusy) {
					System.out.println("BFS");
					isBFS = true;
				}
			}
		});

		JButton ResetButton = new JButton("Reset");
		ResetButton.setBounds(215, 5, 100, 50);
		Canvas.getFrame().add(ResetButton);
		ResetButton.repaint();

		ResetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!isBusy) {
					System.out.println("Reset");
					isReset = true;
				}
			}
		});

		while (true) {

			DFSButton.repaint();
			BFSButton.repaint();
			ResetButton.repaint();

			if (isDFS) {
				isBusy = true;
				Pathfinding.depthFirstSearch(graph, graph.vertices().get(intialPoint), board);
				isDFS = false;
				isBusy = false;
			}

			if (isBFS) {
				isBusy = true;
				Pathfinding.breadthFirstSearch(graph, graph.vertices().get(intialPoint), board);
				isBFS = false;
				isBusy = false;
			}

			if (isReset) {
				isBusy = true;
				Utilities.resetBoard(board, verticesRemoved, graph);
				isReset = false;
				isBusy = false;
			}

		}
	}
}
