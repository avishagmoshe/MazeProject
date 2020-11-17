package algorithms.search;

import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.Position;
import java.util.ArrayList;

public class SearchableMaze implements ISearchable {

    private Maze maze;
    private int [][] directions = {{0,1},{1,0},{0,-1},{-1,0},{-1,-1},{1,1},{1,-1},{-1,1}};

    public SearchableMaze(Maze maze){

        this.maze = maze;
    }

    @Override
    public AState getStartState() {

        return fromPositionToState(maze.getStartPosition());
    }

    @Override
    public AState getGoalState() {

        return fromPositionToState(maze.getGoalPosition());
    }

    @Override
    public ArrayList<AState> getAllPossibleStates(AState s) {
        ArrayList<AState> res = new ArrayList<>();
        Position currentNode = fromAStateToPosition(s);
        for(int i = 0 ; i < directions.length ; i ++){
            int x = currentNode.getRowIndex() + directions[i][0];
            int y = currentNode.getColumnIndex() + directions[i][1];
            if( x < maze.getRows() && x >= 0 && y < maze.getColumns() && y >= 0){
                if(maze.getMaze()[x][y] == 0){
                    Position currentPosition = new Position(x,y);
                    res.add(fromPositionToState(currentPosition));
                }

            }

        }

        return  res;
    }

    private AState fromPositionToState(Position position){
        String stateName =  position.getRowIndex() + "," + position.getColumnIndex() ;
        AState res = new MazeState(stateName);
        return res;
    }

    private Position fromAStateToPosition(AState state){
        String stateName = state.getState();
        String [] values = stateName.split(",");
        Position res = new Position(Integer.parseInt(values[0]) , Integer.parseInt(values[1]));
        return res;

    }
}
