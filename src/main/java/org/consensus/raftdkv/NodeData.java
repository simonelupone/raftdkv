package org.consensus.raftdkv;

import lombok.Data;

/**
 * Node structure
 * 
 * Every Node has the String ID instead of int because it won't be any
 * mathemathical operations with it.
 * The currentTerm is a long cuz we need a huge amount of bytes (32 in this
 * case) to be reliable in long term.
 * The NodeState represent on of the 3 possible state of a Node.
 * 
 * In this case, I used the Lombok library so that I could focus mainly on the
 * logic without polluting the code with boilerplate. Instead of Data annotation
 * I could've use:
 * 
 * @Getter
 * @Setter
 * @AllArgsConstructor
 * 
 * @Data - includes Getter, Setter, toString...etc
 *       Note: this annotation generates an empty constructor if the fields
 *       aren't final.
 *       In this case the constructor will be empty.
 * 
 *       This Object now is mutable, which is conceptually wrong, but I accept
 *       the risk for now.
 */

// TODO: implement @Value and @Builder to build the object safely
@Data
public class NodeData {
    private String id;
    private long currentTerm;
    private NodeState state;
}
