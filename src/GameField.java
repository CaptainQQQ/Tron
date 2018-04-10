import java.awt.*;

public class GameField {

    private int width, height;

    public GameField (int width, int height){
        this.width = width;
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public boolean isInside(int x, int y){
        return x >= 0 && x < width &&
                y >=0 && y < height;
    }

    public void draw(Graphics2D g2, int screenWidth, int screenHight){
        final int GRID_SIZE = 1;
        final Color CELL_COLOR = Color.MAGENTA;

        int minSideSize = Math.min(screenHight, screenWidth);

        int cellWidth = minSideSize / width;
        int cellHight = minSideSize / height;

        int shiftByX = (screenWidth - width * cellWidth) / 2;
        int shiftByY = (screenHight - height * cellHight) / 2;

        g2.setColor(CELL_COLOR);
        for (int y = 0; y < height; y++){
            for (int x = 0; x < width; x++){
                g2.fillRect(shiftByX + x * cellWidth,
                            shiftByY +y * cellHight,
                            cellWidth - GRID_SIZE,
                            cellHight - GRID_SIZE);
            }
        }
    }
}
