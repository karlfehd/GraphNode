package com.sample;

public class GraphApp {
    @SuppressWarnings("UseOfSystemOutOrSystemErr")
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

        System.out.println("Walk graph from node: A");
        System.out.print(A.walkGraph(A));

        System.out.println("\n\nWalk graph from node: B");
        System.out.print(B.walkGraph(B));

        System.out.println("\n\nPaths for node: A");
        System.out.print(A.paths(A));

        System.out.println("\n\nPaths for node: B");
        System.out.print(A.paths(B));
    }
}
