package algorithms.search;

import java.util.ArrayList;

public class Solution {

    ArrayList<AState> solutionPath;

    public Solution(){
        solutionPath = new ArrayList<>();
    }
    public void startBuildingSolutionPath(AState node){
        AState current = node;
        while( current != null){
            addToSolutionPath(node);
            current = node.getCameFrom();
        }
    }

    public void addToSolutionPath(AState node){
        solutionPath.add( 0 , node );
    }
    public ArrayList<AState> getSolutionPath(){
        return null;
    }

}
