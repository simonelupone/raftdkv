package org.consensus.raftdkv;

/**
 * This enum rapresents the 3 states of a node
 * 
 * - FOLLOWER: the initial (passive) state of each node. A follower node is only
 * enabled to receive requests from CANDIDATE and LEADER nodes.
 * 
 * - CANDIDATE: the state a node assumes when it wants to become a leader. In
 * this state, the node asks the other nodes for votes.
 * 
 * - LEADER: the active state. There is only one Leader at any given time. It
 * manages all client requests and replicates the log to the other nodes
 * (FOLLOWER).
 */
public enum NodeState {
    FOLLOWER,
    CANDIDATE,
    LEADER
}
