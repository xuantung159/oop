//
// TetrisGrid encapsulates a tetris board and has
// a clearRows() capability.

public class TetrisGrid {
    private boolean[][] grid;

    /**
     * Constructs a new instance with the given grid.
     * Does not make a copy.
     *
     * @param grid
     */
    public TetrisGrid(boolean[][] grid) {
        this.grid = grid;
    }


    /**
     * Does row-clearing on the grid (see handout).
     */
    public boolean check(int j) {
        for (int i = 0; i < grid.length; i++) {
            if (!grid[i][j]) {
                return false;
            }
        }
        return true;
    }

    public void clearRows() {
        int height = grid[0].length;
        int width = grid.length;

        for (int y = 0; y < height; y++) {
            if (check(y)) {
                for (int yy = y; yy < height - 1; yy++) {
                    for (int x = 0; x < width; x++) {
                        grid[x][yy] = grid[x][yy + 1];
                    }
                }
                for (int x = 0; x < width; x++) {
                    grid[x][height - 1] = false;
                }
                y--;
            }
        }
    }

    /**
     * Returns the internal 2d grid array.
     *
     * @return 2d grid array
     */
    public boolean[][] getGrid() {
        return this.grid; // YOUR CODE HERE
    }

    public static void main(String[] args) {

        boolean[][] before =
                {
                        {true, true, false,},
                        {true, true, true,}
                };
        TetrisGrid grid = new TetrisGrid(before);
        grid.clearRows();

        for (int j = 0; j < grid.grid.length; j++) {
            for (int k = 0; k < grid.grid[0].length; k++) {
                System.out.print(grid.grid[j][k] + " ");
            }
            System.out.println();
        }
    }
}
