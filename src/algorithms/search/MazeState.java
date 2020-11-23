package algorithms.search;

public class MazeState extends AState {


    public MazeState(String state){
        super(state);
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MazeState)) return false;
        MazeState mazeState = (MazeState) o;
        return this.getState().equals(mazeState.getState());
//        if (this.state.equals(mazeState.state)) {
//            return true;
//        }
//        return false;
    }

    @Override
    public int hashCode() {
        return this.getState().hashCode();
    }
}
