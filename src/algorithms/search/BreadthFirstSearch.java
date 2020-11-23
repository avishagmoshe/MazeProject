package algorithms.search;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;

public class BreadthFirstSearch extends ASearchingAlgorithm {


    PriorityQueue<AState> neighbors;

    public BreadthFirstSearch(){
        super();
        neighbors = new PriorityQueue<>((o1, o2) -> 0);
    }

    public String getName(){
        return "BreadthFirstSearch";
    }

    @Override
    public Solution solve(ISearchable searchable) {
        if(searchable == null)
            return null;
        HashSet<AState> visitedNodes = new HashSet<>();
        neighbors.add(searchable.getStartState());
        while( !neighbors.isEmpty() ){
            AState currentNode = neighbors.poll();
            if(currentNode != null) {
                if( currentNode.equals(searchable.getGoalState())){
                    solution.findPath(currentNode);
                    return solution;
                }
                ArrayList<AState> nodeNeighbors = searchable.getAllPossibleStates(currentNode);
                visitedNodes.add(currentNode);
                numberOfNodesEvaluated ++;
                for( int i = 0 ; i < nodeNeighbors.size() ; i++){
                    AState currentNeighbor = nodeNeighbors.get(i);
                    if( !visitedNodes.contains(currentNeighbor)){
                        neighbors.add(currentNeighbor);
                        currentNeighbor.setCameFrom(currentNode);
                    }
                }

            }


        }

    return null;
    }

}
