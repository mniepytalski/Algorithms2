package pl.cbr.graph;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Mariusz on 2015-06-29.
 */
public class Graph {

    List<GraphNode> list;

    public Graph() {

    }

    public void readGraph(String file) throws IOException {

        Map<String, GraphNode> map = new HashMap<>();
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
            String[] a1   = line.split("\\|");
            if (a1 != null) {
                GraphNode   graphNode = new GraphNode();
                graphNode.setName(a1[0]);
                map.put(a1[0], graphNode);
                if (a1.length > 1) {
                    graphNode.setExt(a1[1]);
                }
            }
        }

        for (GraphNode node : map.values()) {
            String[] a2 = node.getExt().split("\\,");
            if (a2 != null) {
                for (String a : a2) {
                    GraphNode n = map.get(a);
                    node.addNode(n);
                }
            }
        }
        list = new ArrayList<>(map.values());
        System.out.println("size: " + map.size());
    }

    public static void main(String[] args) throws IOException {
        Graph graph = new Graph();
        graph.readGraph("graph1.txt");
    }
}
