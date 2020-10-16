GraphNode
=========

Solutions for Graph Node problem

## Imagine we have an interface "GNode" that looks like this:

``` 
public interface GNode {
    public String getName();
    public GNode[] getChildren();
}
```
* Observe that this GNode can be thought of as defining a graph.
* In implementing the functions below, you can assume that any
  graph defined by a GNode is acyclic (no cycles).
* Assume that when a GNode has no children, getChildren() returns
  a array of size 0, and *not* null.
* You can also assume that all children returned by getChildren()
  are not null.  


###1. Implement a function with the following signature:
```
public ArrayList walkGraph(GNode);
```
 
Which should return a ArrayList containing every GNode in the graph.
Each node should appear in the ArrayList exactly once
(i.e. no duplicates).  


###2. Implement a function with the following signature:
``` 
public ArrayList paths(GNode node);
```

Which should return a ArrayList of ArrayLists, representing all
possible paths through the graph starting at 'node'. The ArrayList
returned can be thought of as a ArrayList of paths, where each path
is represented as an ArrayList of GNodes.  

Example:  
   Assume the following graph:
``` 
A
  B
    E
    F
  C
    G
    H
    I
  D
    J
``` 
```
paths(A) = ( (A B E) (A B F) (A C G) (A C H) (A C I) (A D J) )
```

###3. This can be found under ../count-examples
 
