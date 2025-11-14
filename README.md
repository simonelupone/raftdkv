# Raft Distribuited Key-Value Database DEMO

## Background and motivation

As a full-stack developer i've learn how to build a simple Backend with a bunch of programming language like php and its framework Laravel, Javascript and Node.js (in particular Rest API with Express.js) and lately Java with Spring Boot. Thanks to my curiosity, I've always had a tendency to dig deeper. When I came across distributed systems, I wanted to look under the hood and stumbled upon RAFT. The simplicity used in the [paper](https://raft.github.io/raft.pdf) to explain this mechanism immediately fascinated me, and given my skills (still to be improved) in Java, I decided to get hands-on with it.

So here we are, attempting to implement this wonderful algorithm in a Java project.

To dig even deeper down the rabbit hole, I am currently expanding my knowledge of distributed systems thanks to MIT course 6.824 taught by Professor Robert Morris. https://pdos.csail.mit.edu/6.824/

## The paper: In Search of an Understandable Consensus Algorithm

### Intelligibility

The motivation behind the design of Raft **understandability**.

Raft applies specific techniques to improve intelligibility:

1. **Problem Decomposition**: Raft breaks the overall consensus problem managing a replicated log for a state machine into three relatively independent subproblems: _Leader Election_, _Log Replication_, and _Safety_

2. **State Space Reduction**: Raft increases the degree of coherency across servers compared to Paxos, thus reducing the number of inconsistent states that must be considered and simplifying the system's behavior.

### Raft Core

In a Raft cluster, servers operate in one of three states: Leader, Follower, or Candidate. Time is organized into consecutive terms, each beginning with an election.

#### Strong Leader

Raft uses a strong form of _leadership_. The leader is solely responsible for **accepting** client commands, **managing** the **replicated** log, and **directing** data flow. Log entries flow exclusively from the leader to the followers (Leader Append-Only property).

#### Leader Election

**Elections** are triggered when a Follower's election timeout elapses without receiving a heartbeat from the current leader. The follower transitions to a Candidate, increments its term, votes for itself, and requests votes from others. A candidate wins if it receives votes from a majority of the cluster servers (Election Safety). To prevent recurring split votes, Raft uses randomized election timeouts.

#### Log Replication and Safety

The leader replicates log entries using AppendEntries RPCs. An entry is considered committed once it has been safely replicated to a majority of servers.

> Raft enforces _key safety_ properties:
>
> **Log Matching**: If two logs share an entry with the same index and term, then all preceding entries are identical.
> **Leader Completeness**: This property guarantees that the leader for any given term contains all entries committed in previous terms.
>
> This is enforced by an election restriction in the RequestVote RPC: a server will deny a vote if its own log is "more up-to-date" than the candidate's.

#### Advanced Features

Raft manages _Cluster Membership Changes_ using a joint consensus approach, where the old and new configurations overlap during the transition to guarantee safety. To handle unbounded log growth, Raft utilizes snapshotting, where committed entries are replaced by a snapshot of the state machine's current state on stable storage.
