// Test cases for CharGrid -- a few basic tests are provided.

import org.junit.Test;
import static junit.framework.TestCase.assertEquals;

public class CharGridTest {
    @Test
    public void testCharArea1() {
        char[][] grid = new char[][] {
                {'a', 'y', ' '},
                {'x', 'a', 'z'},
        };

        CharGrid cg = new CharGrid(grid);

        assertEquals(4, cg.charArea('a'));
        assertEquals(1, cg.charArea('z'));
    }

    @Test
    public void testCharArea2() {
        char[][] grid = new char[][] {
                {'c', 'a', ' '},
                {'b', ' ', 'b'},
                {' ', ' ', 'a'}
        };

        CharGrid cg = new CharGrid(grid);

        assertEquals(6, cg.charArea('a'));
        assertEquals(3, cg.charArea('b'));
        assertEquals(1, cg.charArea('c'));
    }

    @Test
    public void testCount1() {
        char[][] board = {
                {' ', ' ', 'p', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', 'p', ' ', ' ', ' ', 'x', ' ', ' '},
                {'p', 'p', 'p', 'p', 'p', 'x', 'x', 'x', 'x'},
                {' ', ' ', 'p', ' ', 'y', ' ', 'x', ' ', ' '},
                {' ', ' ', 'p', ' ', 'y', 'y', 'y', ' ', ' '},
                {'z', 'z', 'z', 'z', 'z', 'y', 'z', 'z', 'z'},
                {' ', ' ', 'x', 'x', ' ', 'y', ' ', ' ', ' '}
        };
        CharGrid cg = new CharGrid(board);
        assertEquals(2,  cg.countPlus());
    }
    @Test
    public void testCount2() {
        char[][] board = {
                {'a', 'b', 'c'},
                {'d', 'e', 'f'},
                {'g', 'h', 'i'}
        };
        CharGrid cg = new CharGrid(board);
        assertEquals(0, cg.countPlus());
    }
    @Test
    public void testCount3() {
        char[][] board = {
                {' ', 'a', ' '},
                {'a', 'a', 'a'},
                {' ', 'a', ' '}
        };
        CharGrid cg = new CharGrid(board);
        assertEquals(1, cg.countPlus());
    }
    @Test
    public void testCount4() {
        char[][] board = {
                {' ', 'a', ' ', ' ', 'b', ' ', ' '},
                {'a', 'a', 'a', 'b', 'b', 'b', 'b'},
                {' ', 'a', ' ', ' ', 'b', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '}
        };
        CharGrid cg = new CharGrid(board);
        assertEquals(2, cg.countPlus());
    }
}
