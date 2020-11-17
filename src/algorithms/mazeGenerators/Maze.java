package algorithms.mazeGenerators;

public class Maze {

    int rows;
    int columns;
    int [][] maze;
    Position startPosition;
    Position endPosition;

    public Maze(int rows , int columns){
        this.rows = rows;
        this.columns = columns;
        this.maze = new int [rows][columns];
        //this.startPosition = new Position(0,0);
        //this.endPosition = new Position(3,3);

    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public int[][] getMaze() {
        return maze;
    }

    public void setMaze(int[][] maze) {
        this.maze = maze;
    }
    //todo
    public Position getStartPosition(){
        return this.startPosition;
    }
    //todo
    public Position getGoalPosition(){
        return this.endPosition;
    }

    public void print() {

        Position start = getStartPosition();
        Position end = getGoalPosition();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if(i == start.row && j == start.column)
                    System.out.print("S , ");
                else
                    if(i == end.row && j == end.column)
                        System.out.print("E , ");
                    else
                        System.out.print(maze[i][j]+" , ");
            }
            System.out.println();
        }
    }
}

