package org.effrafax.lettersoup.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class Graph<T> {
	private final Map<T,Set<T>> neighbours = new HashMap<T, Set<T>>();
	
	public void addVertex(T vertex) {
		if (!contains(vertex)) {
			initializeNeighboursFor(vertex);
		}
	}

	private boolean contains(T vertex) {
		return neighbours.containsKey(vertex);
	}
	
	private void initializeNeighboursFor(T vertex) {
		neighbours.put(vertex, new HashSet<T>());
	}
	

	public void addEdge(T u, T v) {
		neighboursOf(u).add(v);
		neighboursOf(v).add(u);
	}

	private Set<T> neighboursOf(T vertex) {
		return neighbours.get(vertex);
	}

}
