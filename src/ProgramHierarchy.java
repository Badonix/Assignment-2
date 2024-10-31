import acm.graphics.GLabel;
import acm.graphics.GLine;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

public class ProgramHierarchy extends GraphicsProgram {
    private static final double BLOCK_WIDTH = 200;
    private static final double BLOCK_HEIGHT = 70;
    private static final double DISTANCE_BETWEEN_CLASSES_X = 50;
    private static final double DISTANCE_BETWEEN_CLASSES_Y = 150;
    private static final String PARENT_NODE_TEXT = "Program";
    private static final String FIRST_CHILD_TEXT = "GraphicsProgram";
    private static final String SECOND_CHILD_TEXT = "ConsoleProgram";
    private static final String THIRD_CHILD_TEXT = "DialogProgram";

    public void run() {
        double centerX = getWidth() / 2;
        double centerY = getHeight() / 2;
        // All second row has same Y coordinate
        double childRowY = centerY + DISTANCE_BETWEEN_CLASSES_Y / 2;
        // Drawing parent node, we need X and Y of this for other blocks, so we do not create separate method for it
        double parentNodeX = centerX - BLOCK_WIDTH / 2;
        double parentNodeY = centerY - DISTANCE_BETWEEN_CLASSES_Y / 2;
        drawBlock(PARENT_NODE_TEXT, parentNodeX, parentNodeY);
        // All child coordinates are based on parent's coordinates
        drawFirstChild(parentNodeX, parentNodeY, childRowY);
        drawSecondChild(parentNodeX, parentNodeY, childRowY);
        drawThirdChild(parentNodeX, parentNodeY, childRowY);
    }

    public void drawBlock(String text, double x, double y) {
        GRect block = new GRect(x, y, BLOCK_WIDTH, BLOCK_HEIGHT);
        GLabel label = new GLabel(text);
        // Center the label inside rectangle
        double labelX = x + (BLOCK_WIDTH - label.getWidth()) / 2;
        double labelY = y + BLOCK_HEIGHT / 2;
        label.setLocation(labelX, labelY);
        add(block, x, y);
        add(label);
    }


    private void drawFirstChild(double parentNodeX, double parentNodeY, double childRowY) {
        double firstChildX = parentNodeX - DISTANCE_BETWEEN_CLASSES_X - BLOCK_WIDTH;
        drawBlock(FIRST_CHILD_TEXT, firstChildX, childRowY);
        connectToParentNode(firstChildX + BLOCK_WIDTH / 2, childRowY, parentNodeX + BLOCK_WIDTH / 2, parentNodeY + BLOCK_HEIGHT);
    }

    private void drawSecondChild(double parentNodeX, double parentNodeY, double childRowY) {
        drawBlock(SECOND_CHILD_TEXT, parentNodeX, childRowY);
        connectToParentNode(parentNodeX + BLOCK_WIDTH / 2, childRowY, parentNodeX + BLOCK_WIDTH / 2, parentNodeY + BLOCK_HEIGHT);
    }

    private void drawThirdChild(double parentNodeX, double parentNodeY, double childRowY) {
        double thirdChildX = parentNodeX + DISTANCE_BETWEEN_CLASSES_X + BLOCK_WIDTH;
        drawBlock(THIRD_CHILD_TEXT, thirdChildX, childRowY);
        connectToParentNode(thirdChildX + BLOCK_WIDTH / 2, childRowY, parentNodeX + BLOCK_WIDTH / 2, parentNodeY + BLOCK_HEIGHT);
    }

    private void connectToParentNode(double x, double y, double parentX, double parentY) {
        GLine line = new GLine(x, y, parentX, parentY);
        add(line);
    }
}
