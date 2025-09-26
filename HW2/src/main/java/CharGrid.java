
public class CharGrid {
    private char[][] grid;

    /**
     * Constructs a new CharGrid with the given grid.
     * Does not make a copy.
     *
     * @param grid
     */
    public CharGrid(char[][] grid) {
        this.grid = grid;
    }

    /**
     * Returns the area for the given char in the grid. (see handout).
     *
     * @param ch char to look for
     * @return area for given char
     */
    public int charArea(char ch) {
        int minI = 100000, maxI = 0, minJ = 100000, maxJ = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == ch) {
                    minI = Math.min(minI, i);
                    maxI = Math.max(maxI, i);
                    minJ = Math.min(minJ, j);
                    maxJ = Math.max(maxJ, j);
                }
            }
        }
        int res = (maxJ - minJ + 1) * (maxI - minI + 1);

        return res; // YOUR CODE HERE
    }

    private boolean check(int i, int j) {
        char ch = grid[i][j];
        int len = 0;

        int cnt = 0;
        for (int y = j; y < grid[0].length; y++) {
            if (grid[i][y] == ch) cnt++;
            else break;
        }
        if (cnt < 2) return false;

        cnt = 0;
        for (int y = j; y >= 0; y--) {
            if (grid[i][y] == ch) cnt++;
            else break;
        }
        if (cnt < 2) return false;

        cnt = 0;
        for (int x = i; x < grid.length; x++) {
            if (grid[x][j] == ch) cnt++;
            else break;
        }
        if (cnt < 2) return false;

        cnt = 0;
        for (int x = i; x >= 0; x--) {
            if (grid[x][j] == ch) cnt++;
            else break;
        }
        if (cnt < 2) return false;

        return true;
    }

    /**
     * Returns the count of '+' figures in the grid (see handout).
     *
     * @return number of + in grid
     */
    public int countPlus() {
        int res = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(check(i, j)) {
                    res++;
                }
            }
        }
        return res; // YOUR CODE HERE
    }

}
