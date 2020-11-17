package algorithms.search;

public abstract class AState {

    private String state;
    private double cost;
    private AState cameFrom;

    public AState(String state){
        this.state = state;

    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public AState getCameFrom(){
        return cameFrom;
    }
    public void setCameFrom(AState state){
        this.cameFrom = state;
    }

}
