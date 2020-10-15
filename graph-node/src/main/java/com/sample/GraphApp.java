package com.sample;

import java.util.ArrayList;

public class GraphApp {
    public static void main(String... args) {
        GNode A = new GNodeImpl("A");
        GNode B = new GNodeImpl("B");
        GNode C = new GNodeImpl("C");
        GNode D = new GNodeImpl("D");
        GNode E = new GNodeImpl("E");
        GNode F = new GNodeImpl("F");
        GNode G = new GNodeImpl("G");
        GNode H = new GNodeImpl("H");
        GNode I = new GNodeImpl("I");
        GNode J = new GNodeImpl("J");

        A.addChild(B);
        A.addChild(C);
        A.addChild(D);
        B.addChild(E);
        B.addChild(F);
        C.addChild(G);
        C.addChild(H);
        C.addChild(I);
        D.addChild(J);

        ArrayList graphA = A.walkGraph(A);
        ArrayList graphB = B.walkGraph(B);
        ArrayList pathA = A.paths(A);
        ArrayList pathB = B.paths(B);

        System.out.println("Walk graph from node: A");
        for (Object o : graphA) {
            System.out.print(((GNode) o).getName() + ' ');
        }

        System.out.println("\n\nRaw Print of node: B");
        System.out.print(graphB);

        System.out.println("\n\nPath list from node: A");
        System.out.print(pathA);

        System.out.println("\n\nPath list from node: B");
        System.out.print(pathB);
    }
}
