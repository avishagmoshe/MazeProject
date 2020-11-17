package algorithms.search;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

public class DepthFirstSearch extends ASearchingAlgorithm {

    public String getName(){
        return "DepthFirstSearch";
    }

    @Override
    public Solution solve(ISearchable searchable) {
        if( searchable == null)
            return null;
        Stack<AState> neighbors = new Stack<>();
        neighbors.add( searchable.getStartState() );
        if( !neighbors.isEmpty() ){
            HashSet<AState> visitedNodes = new HashSet<>();
            AState currentNode = neighbors.pop();
            if(!visitedNodes.contains(currentNode)){
                visitedNodes.add(currentNode);
                if( currentNode.equals(searchable.getGoalState())){
                    solution.startBuildingSolutionPath(currentNode);
                    return solution;
                    }
                ArrayList<AState> nodeNeighbors = searchable.getAllPossibleStates(currentNode);
                numberOfNodesEvaluated ++;
                for(int i = 0 ; i < nodeNeighbors.size() ; i++){
                    if( !visitedNodes.contains(nodeNeighbors.get(i))) {
                        neighbors.push(nodeNeighbors.get(i));
                        nodeNeighbors.get(i).setCameFrom(currentNode);
                    }
                }
            }

            }

        return null;
    }
}
