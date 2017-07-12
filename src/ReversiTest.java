import java.awt.*;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * Test class Reversi
 */
public class ReversiTest {
    
    int[][] emptyBoard = new int[][]{
        {0, 0, 0, 0, 0, 0, 0, 0,},
        {0, 0, 0, 0, 0, 0, 0, 0,},
        {0, 0, 0, 0, 0, 0, 0, 0,},
        {0, 0, 0, 0, 0, 0, 0, 0,},
        {0, 0, 0, 0, 0, 0, 0, 0,},
        {0, 0, 0, 0, 0, 0, 0, 0,},
        {0, 0, 0, 0, 0, 0, 0, 0,},
        {0, 0, 0, 0, 0, 0, 0, 0,}
    };
    
    @Test
    public void testInBounds() {
        Reversi game = new Reversi();
        
        assertTrue(game.inBounds(0, 0));
        assertFalse(game.inBounds(0, 10));
        assertTrue(game.inBounds(5, 3));
        assertFalse(game.inBounds(5, 10));
        assertFalse(game.inBounds(10, 10));
    }
    
    @Test
    public void testIsLegal() {
        //1 is all legal moves allowed on the board
        Reversi game = new Reversi();
        int[][] board1 = new int[][]{
            {0, 0, 0, 0, 0, 0, 0, 0,},
            {0, 0, 0, 0, 0, 0, 0, 0,},
            {0, 0, 0, 0, 1, 0, 0, 0,},
            {0, 0, 0, 0, 0, 1, 0, 0,},
            {0, 0, 1, 0, 0, 0, 0, 0,},
            {0, 0, 0, 1, 0, 0, 0, 0,},
            {0, 0, 0, 0, 0, 0, 0, 0,},
            {0, 0, 0, 0, 0, 0, 0, 0,}
        };
        
        //test up
        int[][] board2 = new int[][]{
            {0, 0, 0, 0, 0, 0, 0, 0,},
            {0, 0, 0, 0, 0, 0, 0, 0,},
            {0, 0, 0, 1, 0, 1, 0, 0,},
            {0, 0, 0, 0, 0, 0, 0, 0,},
            {0, 0, 0, 0, 0, 1, 0, 0,},
            {0, 0, 0, 0, 0, 0, 0, 0,},
            {0, 0, 0, 0, 0, 0, 0, 0,},
            {0, 0, 0, 0, 0, 0, 0, 0,}
        };
        
        //test diaganol
        int[][] board3 = new int[][]{
            {0, 0, 0, 0, 0, 0, 0, 0,},
            {0, 0, 0, 0, 0, 0, 0, 0,},
            {0, 0, 0, 0, 0, 0, 1, 0,},
            {0, 0, 0, 0, 0, 1, 0, 0,},
            {0, 0, 1, 0, 0, 0, 0, 0,},
            {0, 0, 0, 1, 0, 0, 0, 0,},
            {0, 0, 0, 0, 0, 0, 0, 0,},
            {0, 0, 0, 0, 0, 0, 0, 0,}
        };
        
        //test horizontal
        int[][] board4 = new int[][]{
            {0, 0, 0, 0, 0, 0, 0, 0,},
            {0, 0, 0, 0, 1, 0, 0, 0,},
            {0, 0, 0, 1, 0, 0, 0, 0,},
            {0, 0, 1, 0, 0, 0, 0, 0,},
            {0, 0, 0, 0, 0, 0, 0, 0,},
            {0, 0, 1, 0, 1, 0, 0, 0,},
            {0, 0, 0, 0, 0, 0, 0, 0,},
            {0, 0, 0, 0, 0, 0, 0, 0,}
        };                     
        
        //test first legal moves
        assertArrayEquals( board1, listLegalMoves(game));
        //test skip up legal moves
        game.flipSides(game.getButton(2, 4));
        game.updateInfo();
        assertArrayEquals( board2, listLegalMoves(game));
        //test diaganol up legal moves
        game.flipSides(game.getButton(2, 5));
        game.updateInfo();
        assertArrayEquals( board3, listLegalMoves(game));
        //test horizontal legal moves
        game.flipSides(game.getButton(4, 2));
        game.updateInfo();
        assertArrayEquals( board4, listLegalMoves(game));
    }
    
    @Test
    public void testFlipSides() {
        //1 is white, 2 is black
        Reversi game = new Reversi();
        //no moves
        int[][] board1 = new int[][]{
            {0, 0, 0, 0, 0, 0, 0, 0,},
            {0, 0, 0, 0, 0, 0, 0, 0,},
            {0, 0, 0, 0, 0, 0, 0, 0,},
            {0, 0, 0, 1, 2, 0, 0, 0,},
            {0, 0, 0, 2, 1, 0, 0, 0,},
            {0, 0, 0, 0, 0, 0, 0, 0,},
            {0, 0, 0, 0, 0, 0, 0, 0,},
            {0, 0, 0, 0, 0, 0, 0, 0,}
        };
        
        int[][] board2 = new int[][]{
            {0, 0, 0, 0, 0, 0, 0, 0,},
            {0, 0, 0, 0, 0, 0, 0, 0,},
            {0, 0, 0, 0, 1, 0, 0, 0,},
            {0, 0, 0, 1, 1, 0, 0, 0,},
            {0, 0, 0, 2, 1, 0, 0, 0,},
            {0, 0, 0, 0, 0, 0, 0, 0,},
            {0, 0, 0, 0, 0, 0, 0, 0,},
            {0, 0, 0, 0, 0, 0, 0, 0,}
        };
        
        int[][] board3 = new int[][]{
            {0, 0, 0, 0, 0, 0, 0, 0,},
            {0, 0, 0, 0, 0, 0, 0, 0,},
            {0, 0, 0, 0, 1, 2, 0, 0,},
            {0, 0, 0, 1, 2, 0, 0, 0,},
            {0, 0, 0, 2, 1, 0, 0, 0,},
            {0, 0, 0, 0, 0, 0, 0, 0,},
            {0, 0, 0, 0, 0, 0, 0, 0,},
            {0, 0, 0, 0, 0, 0, 0, 0,}
        };
        
        int[][] board4 = new int[][]{
            {0, 0, 0, 0, 0, 0, 0, 0,},
            {0, 0, 0, 0, 0, 0, 0, 0,},
            {0, 0, 0, 0, 1, 2, 0, 0,},
            {0, 0, 0, 1, 2, 0, 0, 0,},
            {0, 0, 1, 1, 1, 0, 0, 0,},
            {0, 0, 0, 0, 0, 0, 0, 0,},
            {0, 0, 0, 0, 0, 0, 0, 0,},
            {0, 0, 0, 0, 0, 0, 0, 0,}
        };
        
        int[][] board5 = new int[][]{
            {0, 0, 0, 0, 1, 0, 0, 0,},
            {0, 0, 0, 0, 1, 0, 0, 0,},
            {0, 0, 0, 0, 1, 2, 0, 0,},
            {0, 0, 0, 1, 1, 0, 0, 0,},
            {0, 0, 1, 1, 1, 0, 0, 0,},
            {0, 0, 0, 0, 0, 0, 0, 0,},
            {0, 0, 0, 0, 0, 0, 0, 0,},
            {0, 0, 0, 0, 0, 0, 0, 0,}
        };
        
        int[][] board6 = new int[][]{
            {0, 0, 0, 0, 1, 0, 0, 0,},
            {0, 0, 0, 0, 1, 0, 0, 0,},
            {0, 0, 0, 0, 1, 2, 0, 0,},
            {0, 0, 0, 1, 2, 0, 0, 0,},
            {0, 0, 1, 2, 1, 0, 0, 0,},
            {0, 0, 2, 0, 0, 0, 0, 0,},
            {0, 0, 0, 0, 0, 0, 0, 0,},
            {0, 0, 0, 0, 0, 0, 0, 0,}
        };
        
        //no moves
        assertArrayEquals( board1, listAllButtons(game));
        //test up to see if board flips vertically
        game.flipSides(game.getButton(2, 4));
        game.updateInfo();
        assertArrayEquals( board2, listAllButtons(game));
        //test to see if the board flips pieces diaganolly
        game.flipSides(game.getButton(2, 5));
        game.updateInfo();
        assertArrayEquals( board3, listAllButtons(game));
        //test to see if board flips pieces horizontally
        game.flipSides(game.getButton(4, 2));
        game.updateInfo();
        assertArrayEquals( board4, listAllButtons(game));
        //test to verticlally flip 3 pieces inbetween
        game.flipSides(game.getButton(1, 4));
        game.updateInfo();
        game.flipSides(game.getButton(0, 4));
        game.updateInfo();
        assertArrayEquals( board5, listAllButtons(game));
        //test to diagonally flip 2 pieces inbetween
        game.flipSides(game.getButton(5, 2));
        game.updateInfo();
        assertArrayEquals( board6, listAllButtons(game));
    }
    
    /**
     * Lists the legal moves in a readable int array
     * @param game the game board that needs to be listed
     * @return 2d int array with all the legal moves in the board where 1 is a legal move and 0 is not
     */
    public int[][] listLegalMoves(Reversi game) {
        int[][] array = new int[8][8];
        for(int i = 0; 8 > i ; i++) {
            for(int j = 0; 8 > j ; j++) {
                if(game.isLegal(game.getButton(i, j)))
                    array[i][j] = 1;
                else
                    array[i][j] = 0;
            }
        }
        return array;
    }
    
    /**
     * Lists the board in a readable int array
     * @param game the game board that needs to be listed
     * @return 2d int array with all the legal moves in the board where 1 is a white piece and 2 is a black piece and 0 is neither
     */
    public int[][] listAllButtons(Reversi game) {
        int[][] array = new int[8][8];
        for(int i = 0; 8 > i ; i++) {
            for(int j = 0; 8 > j ; j++) {
                if((game.getButton(i, j)).getBackground() == Color.WHITE)
                    array[i][j] = 1;
                else if((game.getButton(i, j)).getBackground() == Color.BLACK)
                    array[i][j] = 2;
                else
                    array[i][j] = 0;
            }
        }
        return array;
    }
