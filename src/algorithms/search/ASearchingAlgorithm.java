package algorithms.search;

public abstract class ASearchingAlgorithm implements ISearchingAlgorithm {


    int numberOfNodesEvaluated;
    Solution solution;

    public ASearchingAlgorithm(){
        this.numberOfNodesEvaluated = 0;
        this.solution = new Solution();
    }

    @Override
    public int getNumberOfNodesEvaluated(){
        return numberOfNodesEvaluated;
    }

}
