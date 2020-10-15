package com.sample;

import java.util.ArrayList;


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
    public GNode[] getChildren() {
        GNode[] tempNode = new GNode[children.size()];
        for (int i = 0; i < children.size(); i++)
            tempNode[i] = children.get(i);

        return tempNode;
    }

    @Override
    public void addChild(GNode gNode) {
        children.add(gNode);
    }

    @Override
    public ArrayList<GNodeImpl> walkGraph(GNode gNode) {
        ArrayList<GNode> childList = new ArrayList<>();
        childList.add(gNode);

        ArrayList<GNodeImpl> tempList = new ArrayList<>();
        while (!childList.isEmpty()) {

            GNodeImpl currentnode = (GNodeImpl) childList.remove(0);

            if (!tempList.contains(currentnode)) {
                tempList.add(currentnode);
            }

            if (currentnode.getChildren().length > 0) {

                for (int i = 0; i < currentnode.getChildren().length; i++) {

                    if (!childList.contains(currentnode.getChildren()[i])) {
                        childList.add(currentnode.getChildren()[i]);
                    }
                }
            }
        }
        return tempList;
    }

    @Override
    public ArrayList paths(GNode gNode) {
        ArrayList<ArrayList<GNode>> tempList = new ArrayList<>();
        if (gNode.getChildren().length > 0) {
            for (GNode child : gNode.getChildren()) {
                tempList.addAll(paths(child));
            }
            for (ArrayList<GNode> child : tempList) {
                child.add(0, gNode);
            }
        } else {
            ArrayList<GNode> thisnode = new ArrayList<>();
            thisnode.add(gNode);
            tempList.add(thisnode);
        }
        return tempList;
    }
}
