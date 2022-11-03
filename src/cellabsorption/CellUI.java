package cellabsorption;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Point;

public class CellUI {
    public static void main(String[] args) {
        new CellUI(800, 800);
    }

    public CellUI(int width, int height) {
        CanvasWindow canvas = new CanvasWindow("Cell Absorption", width, height);
        Point centerOfCanvas = new Point(width / 2.0, height / 2.0);

        CellSimulation simulation = new CellSimulation(centerOfCanvas);
        simulation.createRandomCells(10);
        canvas.add(simulation);

        //noinspection InfiniteLoopStatement
        while (true) {
            simulation.update();

            canvas.draw();
            canvas.pause(17);
        }
    }
}
