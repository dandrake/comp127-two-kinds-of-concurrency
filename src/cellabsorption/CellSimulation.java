package cellabsorption;

import edu.macalester.graphics.*;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SuppressWarnings("SameParameterValue")
public class CellSimulation extends GraphicsGroup {

    private final Random rand = new Random();
    private final List<Cell> cells = new ArrayList<>();
    private final Point attractor;

    public CellSimulation(Point attractor) {
        this.attractor = attractor;
    }

    public void update() {
        for (Cell cell : cells) {
            cell.moveAround(attractor);
        }
        handleCellInteraction();
    }

    public void createRandomCells(int count) {
        for (int i = 0; i < count; i++) {
            double size = rand.nextInt(5) + 2;
            createCell(
                attractor.add(
                    Point.atAngle(rand.nextDouble() * Math.PI * 2)
                        .scale(rand.nextDouble() * 100)),
                size);
        }
    }

    public Cell createCell(Point position, double size) {
        Cell cell = new Cell(
            position.getX(), position.getY(), size,
            Color.getHSBColor(rand.nextFloat(), rand.nextFloat() * 0.5f + 0.1f, 1));
        add(cell.getShape());
        cells.add(cell);
        return cell;
    }

    private void handleCellInteraction() {
        for (int i = 0; i < cells.size(); i++) {
            Cell cell0 = cells.get(i);
            for (int j = i + 1; j < cells.size(); j++) {
                Cell cell1 = cells.get(j);
                cell0.interactWith(cell1);
            }
        }
    }
}
