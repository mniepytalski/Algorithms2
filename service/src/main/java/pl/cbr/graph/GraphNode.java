package pl.cbr.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mariusz on 2015-06-29.
 */
public class GraphNode {

    String  name;
    List<GraphNode> nodes;
    String  ext;
    NodeColor  color;

    public GraphNode() {
        nodes   = new ArrayList<GraphNode>();
        color   = NodeColor.Bialy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<GraphNode> getNodes() {
        return nodes;
    }

    public void setNodes(List<GraphNode> nodes) {
        this.nodes = nodes;
    }

    public void addNode(GraphNode node) {
        nodes.add(node);
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public NodeColor getColor() {
        return color;
    }

    public void setColor(NodeColor color) {
        this.color = color;
    }

    public String toString() {
        String external = "";
        int count = 0;
        for (GraphNode g : nodes) {
            if (count != 0) {
                external += ",";
            }
            external += g.getName();
            count++;
        }
        return getName() + "|" + external;
    }
}
