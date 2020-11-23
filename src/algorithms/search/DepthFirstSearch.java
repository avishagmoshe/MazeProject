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
        HashSet<AState> visitedNodes = new HashSet<>();
        while( !neighbors.isEmpty() ) {
            AState currentNode = neighbors.pop();
            if (currentNode != null) {
                if (currentNode.equals(searchable.getGoalState())) {
                    solution.findPath(currentNode);
                 //   solution.printSolution();
                    return solution;
                }
                visitedNodes.add(currentNode);
                ArrayList<AState> nodeNeighbors = searchable.getAllPossibleStates(currentNode);
                numberOfNodesEvaluated++;
                for (int i = 0; i < nodeNeighbors.size(); i++) {
                    AState neighbor = nodeNeighbors.get(i);
                    if (neighbor != null && !visitedNodes.contains(neighbor)) {
                        neighbor.setCameFrom(currentNode);
                        neighbors.push(neighbor);
                    }

                }
            }
        }

      //  solution.printSolution();
        return null;
    }
}
