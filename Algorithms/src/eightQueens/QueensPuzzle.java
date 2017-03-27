package eightQueens;

import model.Node;

import java.util.LinkedList;

/**
 * @author joan on 27/3/17.
 * @project Algorithms
 * @package eightQueens
 */
public class QueensPuzzle implements Node{
    private int nextQueenPosition;
    private int board[];
    private int numberOfColumns;


    private QueensPuzzle() {}

    public QueensPuzzle(int numberOfColumns) {
        this.board = new int[numberOfColumns];
        this.numberOfColumns = numberOfColumns;
        for (int i = 0; i < numberOfColumns; i++) this.board[i] = -1;
        this.nextQueenPosition = 0;
    }

    private QueensPuzzle(int columnPosition, int[] board) {
        this.numberOfColumns = board.length;
        this.board = new int[this.numberOfColumns];
        for (int i = 0; i < this.numberOfColumns; i++) this.board[i] = board[i];
        this.nextQueenPosition = columnPosition;
    }

    public void addQueen(int column) {
        this.board[nextQueenPosition] = column;
        this.nextQueenPosition++;
    }

    private boolean isConsistent() {
        for (int i = 0; i < this.nextQueenPosition-1; i++) {
            if (board[i] == board[nextQueenPosition-1]) return false;
            if ((board[i] - board[nextQueenPosition-1]) == nextQueenPosition-1-i) return false;
            if ((board[nextQueenPosition-1] - board[i]) == nextQueenPosition-1-i) return false;
        }
        return true;
    }

    @Override
    public LinkedList<Node> successors() {
        LinkedList<Node> successors = new LinkedList<>();
        for (int i = 0; i < this.numberOfColumns; i++) {
            QueensPuzzle nextNode = new QueensPuzzle(nextQueenPosition, board);
            nextNode.addQueen(i);
            if (nextNode.isConsistent()) successors.add(nextNode);
        }
        return successors;
    }

    @Override
    public boolean solution() {
        return this.nextQueenPosition == numberOfColumns;
    }

    @Override
    public void print() {
        for (int i = 0; i < this.numberOfColumns; i++) {
            for (int j = 0; j < this.numberOfColumns; j++) {
                System.out.print(this.board[i] == j ? "Q" : "*");
            }
            System.out.println();
        }
        System.out.println();
    }
}
