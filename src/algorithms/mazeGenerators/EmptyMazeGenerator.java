package algorithms.mazeGenerators;

public class EmptyMazeGenerator extends AMazeGenerator {
    @Override
    public Maze generate(int rows, int columns) {
        return new Maze(0,0);
    }
}
