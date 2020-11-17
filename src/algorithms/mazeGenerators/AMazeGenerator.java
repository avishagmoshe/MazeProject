package algorithms.mazeGenerators;

public abstract class AMazeGenerator implements IMazeGenerator {

    Maze maze;

    @Override
    public abstract Maze generate(int rows, int columns) ;

    @Override
    public long measureAlgorithmTimeMillis(int rows, int columns){
        long startTime = System.currentTimeMillis();
        Maze maze = generate(rows , columns);
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }
}
