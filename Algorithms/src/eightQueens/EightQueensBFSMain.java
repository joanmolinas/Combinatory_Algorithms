package eightQueens;

import model.Node;

import java.util.LinkedList;

/**
 * @author joan on 27/3/17.
 * @project Algorithms
 * @package eightQueens
 */
public class EightQueensBFSMain {
    public static void main(String[] args) {
        QueensPuzzle puzzle = new QueensPuzzle(8);
        QueensPuzzle currentPuzzle;
        LinkedList<Node> nodesToExplore = new LinkedList<>(); //LNO
        LinkedList<Node> childs; //LF

        int numberOfSolutions = 0;
        int memorySpended = 0;

        nodesToExplore.add(puzzle);

        while (!nodesToExplore.isEmpty()) {
            currentPuzzle = (QueensPuzzle) nodesToExplore.getLast();
            nodesToExplore.removeLast();

            if (currentPuzzle.solution()) {
                numberOfSolutions++;
                currentPuzzle.print();
            } else {
                childs = currentPuzzle.successors();
                nodesToExplore.addAll(childs);
            }

            if (memorySpended < nodesToExplore.size()) { memorySpended = nodesToExplore.size(); };
        }

        System.out.println("Solutions : " + numberOfSolutions);
        System.out.println("Memory used : " + memorySpended);
    }
}

