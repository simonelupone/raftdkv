package org.consensus.raftdkv;

/**
 * Node structure
 * 
 * Every Node has the String ID instead of int because it won't be any
 * mathemathical operations with it.
 * The currentTerm is a long cuz we need a huge amount of bytes (32 in this
 * case) to be reliable in long term.
 * The NodeState represent on of the 3 possible state of a Node
 */
public class Node {
    private String id;
    private long currentTerm;
    private NodeState state;
}
