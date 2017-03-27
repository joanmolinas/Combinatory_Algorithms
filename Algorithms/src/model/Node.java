package model;

import java.util.LinkedList;

/**
 * @author joan on 27/3/17.
 * @project Algorithms
 * @package model
 */

public interface Node {

    /**
     * @return a list with all valid possibilities starting on the actual state.
     */
    LinkedList<Node> successors();

    /**
     * @return true if solution was find
     */
    boolean solution();

    /**
     *
     */
    void print();
}
