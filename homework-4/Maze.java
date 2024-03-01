package edu.bloomu.homework5;

/**
 * Takes a maze given by the user and returns up to two possible 
 * solutions to the maze.
 *
 * @author Jessica Ruehle
 */
public class Maze {

    private char[][] maze; // the char array to hold the maze
    private final int width; // the width of the maze
    private final int height; // the height of the maze
    private int numSolutions; // counter for the number of solutions found
    private int currentRow; // the current row the path is at
    private int currentCol; // the current column the path is at
    private int endingRow; // the row of the end point
    private int endingCol; // the column of the end point

    /**
     * Constructor that asks the user to input the dimensions of the board 
     * and creates a new maze
     * @param width the width of the maze
     * @param height the height of the maze
     * @param maze the maze setup
     */
    public Maze(int width, int height, char[][] maze) 
    {
        this.width = width;
        this.height = height;
        this.maze = maze;
        numSolutions = 0;

        //sets the row and column tracker to the starting position and
        // being finding the solutions
        findStartFinish();
        findPath(currentRow, currentCol);
    }

/**
 * Recursively checks all possible paths the maze can take to be solved
 * and keeps a count of the number of solutions. Will print out the
 * first two solutions.
 * 
 * @param row the row to start from
 * @param col the column to start from
 */
    public void findPath(int row, int col) 
    {

        // checking for out of bounds or the path you've already taken
        if (maze[row][col] == '1' || maze[row][col] == 'p') 
        {
            return;
        }

        // check if you've reached the end of the maze
        if (col == endingCol && row == endingRow) 
        {
            
            // after finding the first two solutions, string 
            // concatination allows them to be printed to screen
            if(numSolutions == 1 || numSolutions == 2) 
            {
                String output = "";

                for (int i = 0; i < width; i++) 
                {
                    for (int j = 0; j < height; j++) 
                    {
                        output += maze[i][j];
                    }
                    output += "\n";
                }
                System.out.println(output);
            }
            // increment the number of solutions when one is found
            numSolutions++;
            return;
        }

        // check to the right
        maze[row][col] = 'p';
        findPath(row, col + 1);

        // check down
        maze[row][col] = 'p';
        findPath(row + 1, col);

        // check to the left
        maze[row][col] = 'p';
        findPath(row, col - 1);

        // check up
        maze[row][col] = 'p';
        findPath(row - 1, col);

        // reset the position to 0 if it is not a solution
        maze[row][col] = '0';
    }

    /**
     * Finds the current locations of 'b' and 'e'
     */
    public void findStartFinish()
    {
        // for-loops to iterate through the arrays
        for (int i = 0; i < height; i++)
        {
            for (int j = 0; j < width; j++)
            {
                // when the location of 'b' is found, the class fields 
                // will be updated
                if (maze[i][j] == 'b')
                {
                    currentRow = i;
                    currentCol = j;
                }
                // when the location of 'e' is found, the class fields 
                // will be updated
                if (maze[i][j] == 'e')
                {
                    endingRow = i;
                    endingCol = j;
                }
            }
        }
    }

    /**
     * Overriden toString method formats output
     * @return the maze printed to console
     */
    @Override
    public String toString() 
    {
        // string holds output
        String output = "";

        // iterate through the maze and add every index to the string
        for (int i = 0; i < width; i++) 
        {
            for (int j = 0; j < height; j++) 
            {
                output += maze[i][j];
            }
            output += "\n";
        }
        
        // return the formatted string output
        return output;
    }
}
