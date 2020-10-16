package com.sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class GNodeImpl implements GNode {

    private final String           name;
    private final ArrayList<GNode> children = new ArrayList<>();

    public GNodeImpl(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    public String toString() {
        return name;
    }

    @Override
    public void addChild(GNode gNode) {
        children.add(gNode);
    }

    @Override
    public GNode[] getChildren() {
        return children.toArray(new GNode[0]);
    }

    @Override
    public ArrayList<GNode> walkGraph(GNode gNode) {
        Collection<GNode> visitedNodes = new ArrayList<>();
        List<GNode> notVisitedNodes = new ArrayList<>(Collections.singletonList(gNode));

        while (!notVisitedNodes.isEmpty()) {
            List<GNode> newNodes =
                    (ArrayList<GNode>) notVisitedNodes.stream().map(GNode::getChildren).flatMap(Arrays::stream)
                                                      .filter(node -> !visitedNodes.contains(node))
                                                      .collect(Collectors.toList());

            visitedNodes.addAll(notVisitedNodes);
            notVisitedNodes = newNodes;
        }
        return (ArrayList<GNode>) visitedNodes.stream().distinct().collect(Collectors.toList());
    }

    @Override
    public ArrayList<ArrayList<GNode>> paths(GNode gNode) {
        ArrayList<ArrayList<GNode>> tempList = new ArrayList<>();
        if (gNode.getChildren().length > 0) {
            for (GNode child : gNode.getChildren()) {
                tempList.addAll(paths(child));
            }
            tempList.forEach(child -> child.add(0, gNode));
        } else {
            ArrayList<GNode> node = new ArrayList<>();
            node.add(gNode);
            tempList.add(node);
        }
        return tempList;
    }
}
