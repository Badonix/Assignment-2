import acm.graphics.GRect;
import acm.program.GraphicsProgram;

public class Pyramid extends GraphicsProgram {
    private static final int BRICK_WIDTH = 30;
    private static final int BRICK_HEIGHT = 15;
    private static final int BRICKS_IN_BASE = 14;

    public void run() {
        int currentLineX = (getWidth() - BRICK_WIDTH * BRICKS_IN_BASE) / 2; // X of base of the pyramid
        int currentLineY = getHeight() - BRICK_HEIGHT; // Y of the base of the pyramid
        drawPyramid(currentLineX, currentLineY);
    }

    private void drawPyramid(int startLineX, int startLineY) {
        int currentBricksCount = BRICKS_IN_BASE;
        for (int i = BRICKS_IN_BASE; i > 0; i--) {
            drawBrickLine(currentBricksCount, startLineX, startLineY);
            startLineX += BRICK_WIDTH / 2;
            startLineY -= BRICK_HEIGHT;
            currentBricksCount--;
        }
    }

    // One *row* of pyramid
    private void drawBrickLine(int bricksCount, int x, int y) {
        int currentX = x;
        for (int i = 0; i < bricksCount; i++) {
            currentX += BRICK_WIDTH;
            drawBrick(currentX, y);
        }
    }

    public void drawBrick(int x, int y) {
        GRect brick = new GRect(BRICK_WIDTH, BRICK_HEIGHT);
        add(brick, x, y);
    }
}

