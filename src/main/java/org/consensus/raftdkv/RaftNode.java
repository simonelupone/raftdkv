package org.consensus.raftdkv;

import java.util.UUID;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class RaftNode {
    private NodeData nodeData;

    /**
     * Inizialization of the empty constructor (as provided by @Data directives)
     */
    public RaftNode() {
        this.nodeData = new NodeData();
        this.nodeData.setId(UUID.randomUUID().toString());
        this.nodeData.setCurrentTerm(0);
        this.nodeData.setState(NodeState.FOLLOWER);

        // testing
        System.out.println("Created Node: " + nodeData);
    }

    /**
     * @Scheduled - Sets the task schedulation
     *            The task will be executed the first time after the initialDelay
     *            value, and it will continue to be executed according to the
     *            fixedDelay.
     */
    @Scheduled(initialDelay = 5000, fixedRate = 5000)
    public void handleElectionTimeout() {
        System.out.println(
                "[" + nodeData.getState() + "]" +
                        " Start ElectionTimeout - Node " + nodeData.getId() +
                        "(Term: " + nodeData.getCurrentTerm() + ")");
    }
}
