package algorithms.mazeGenerators;
import java.util.LinkedList;
import java.util.Random;

public class MyMazeGenerator extends AMazeGenerator {



    @Override
    public Maze generate(int rows, int columns) {

        maze = new Maze(rows, columns);
        createsWalls();
        primAlgorithm();
        return maze;
    }

    public void createsWalls() {
        for (int i = 0; i < maze.getRows(); i++) {
            for (int j = 0; j < maze.getColumns(); j++) {
                maze.getMaze()[i][j] = 1;
            }
        }

    }

    public void primAlgorithm() {
        final LinkedList<int[]> possibleSteps = new LinkedList<>();
        final Random random = new Random();
        int x = random.nextInt(maze.getRows());
        int y = random.nextInt(maze.getColumns());
        Position startPosition = new Position(x,y);
        maze.startPosition = startPosition;

        possibleSteps.add(new int[]{x, y, x, y});

        while (!possibleSteps.isEmpty()) {
            final int[] nextPossibleMoves = possibleSteps.remove(random.nextInt(possibleSteps.size()));
            x = nextPossibleMoves[2];
            y = nextPossibleMoves[3];
            if (maze.getMaze()[x][y] == 1) {
                maze.getMaze()[nextPossibleMoves[0]][nextPossibleMoves[1]] = maze.getMaze()[x][y] = 0;
                if (x >= 2 && maze.getMaze()[x - 2][y] == 1)
                    possibleSteps.add(new int[]{x - 1, y, x - 2, y});
                if (y >= 2 && maze.getMaze()[x][y - 2] == 1)
                    possibleSteps.add(new int[]{x, y - 1, x, y - 2});
                if (x < maze.getRows() - 2 && maze.getMaze()[x + 2][y] == 1)
                    possibleSteps.add(new int[]{x + 1, y, x + 2, y});
                if (y < maze.getColumns() - 2 && maze.getMaze()[x][y + 2] == 1)
                    possibleSteps.add(new int[]{x, y + 1, x, y + 2});
            }
        }
        Position endPosition = new Position(x,y);
        maze.endPosition = endPosition;
    }



}