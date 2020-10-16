package com.sample;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GraphAppTest {

    GNode parentNodeA;
    GNode childNodeB;
    GNode childNodeC;
    GNode childNodeD;

    @Before
    public void setUp() throws Exception {
        parentNodeA = new GNodeImpl("A");
        childNodeB = new GNodeImpl("B");
        childNodeC = new GNodeImpl("C");
        childNodeD = new GNodeImpl("D");
    }

    @Test
    public void testAddChild() {
        parentNodeA.addChild(childNodeB);
        assertEquals(childNodeB, parentNodeA.getChildren()[0]);
    }

    @Test
    public void testEmptyChild() {
        assertEquals(0, parentNodeA.getChildren().length);
    }

    @Test
    public void testWalkGraphWithDuplicates() {
        parentNodeA.addChild(childNodeB);
        parentNodeA.addChild(childNodeC);
        childNodeB.addChild(childNodeC);
        parentNodeA.addChild(childNodeD);
        /*  A
              B
                C
              C
              D
         */
        assertEquals("[A, B, C, D]", parentNodeA.walkGraph(parentNodeA).toString());
        assertEquals("[B, C]", parentNodeA.walkGraph(childNodeB).toString());
        assertEquals("[C]", parentNodeA.walkGraph(childNodeC).toString());
    }

    @Test
    public void testPaths() {
        parentNodeA.addChild(childNodeB);
        parentNodeA.addChild(childNodeC);
        childNodeC.addChild(childNodeD);

        assertEquals("[[A, B], [A, C, D]]", parentNodeA.paths(parentNodeA).toString());
    }
}
