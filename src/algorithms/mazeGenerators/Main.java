package algorithms.mazeGenerators;

public class Main {

    public static void main(String[] args){
        MyMazeGenerator myMaze = new MyMazeGenerator();
       // Maze m = myMaze.generate(5,7);


        System.out.println(myMaze.measureAlgorithmTimeMillis(10,15));
        myMaze.maze.print();


    }
}
