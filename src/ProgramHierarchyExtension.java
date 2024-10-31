import acm.graphics.GLabel;
import acm.graphics.GLine;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

public class ProgramHierarchyExtension extends GraphicsProgram {

    private static final double BLOCK_WIDTH = 200;
    private static final double BLOCK_HEIGHT = 70;
    private static final double DISTANCE_BETWEEN_CLASSES_X = 50;
    private static final double DISTANCE_BETWEEN_CLASSES_Y = 150;
    private static final String PARENT_NODE_TEXT = "Program";

    // (extension) Using array to dynamically render child nodes, can easily render 1, 2, 3 or any number of child nodes
    private static final String[] CHILD_TEXTS = {"GraphicsProgram", "ConsoleProgram", "DialogProgram", "RandomProgram"};

    public void run() {
        double centerX = (double) getWidth() / 2;
        double centerY = (double) getHeight() / 2;

        // Draw parent block
        double parentX = centerX - BLOCK_WIDTH / 2;
        double parentY = centerY - DISTANCE_BETWEEN_CLASSES_Y / 2;
        drawBlock(PARENT_NODE_TEXT, parentX, parentY);

        // Draw child blocks dynamically
        double childRowY = centerY + DISTANCE_BETWEEN_CLASSES_Y / 2;
        drawChildren(parentX, parentY, childRowY);
    }

    private void drawChildren(double parentX, double parentY, double childRowY) {
        // Total width of child row
        double totalWidth = CHILD_TEXTS.length * BLOCK_WIDTH + (CHILD_TEXTS.length - 1) * DISTANCE_BETWEEN_CLASSES_X;
        double startX = (getWidth() - totalWidth) / 2;

        for (int i = 0; i < CHILD_TEXTS.length; i++) {
            double childX = startX + i * (BLOCK_WIDTH + DISTANCE_BETWEEN_CLASSES_X);
            drawBlock(CHILD_TEXTS[i], childX, childRowY);
            connectToParentNode(childX + BLOCK_WIDTH / 2, childRowY, parentX + BLOCK_WIDTH / 2, parentY + BLOCK_HEIGHT);
        }
    }

    private void drawBlock(String text, double x, double y) {
        GRect block = new GRect(x, y, BLOCK_WIDTH, BLOCK_HEIGHT);
        GLabel label = new GLabel(text);

        // Center the label inside the rectangle
        double labelX = x + (BLOCK_WIDTH - label.getWidth()) / 2;
        double labelY = y + (BLOCK_HEIGHT + label.getAscent()) / 2;
        label.setLocation(labelX, labelY);

        add(block);
        add(label);
    }

    private void connectToParentNode(double x, double y, double parentX, double parentY) {
        GLine line = new GLine(x, y, parentX, parentY);
        add(line);
    }
}
