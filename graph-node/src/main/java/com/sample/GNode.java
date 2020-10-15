package com.sample;

import java.util.ArrayList;

public interface GNode {
    String getName();

    GNode[] getChildren();

    void addChild(GNode gNode);

    ArrayList walkGraph(GNode gNode);

    ArrayList paths(GNode gNode);
}
