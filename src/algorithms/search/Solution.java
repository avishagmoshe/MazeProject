package algorithms.search;

import java.util.ArrayList;

public class Solution {

    ArrayList<AState> solutionPath;

    public Solution(){

        solutionPath = new ArrayList<>();
    }
    public void findPath(AState node){
        AState current = node;

        while( current != null ){
            solutionPath.add( 0 , current );
            current = current.getCameFrom();
        }

    }
    public void printSolution(){
        System.out.println("inprint solution");
        for(int i=0; i< solutionPath.size();i++){
            System.out.println(solutionPath.get(i).getState());
        }
    }

    public ArrayList<AState> getSolutionPath(){

        return solutionPath;
    }

}
