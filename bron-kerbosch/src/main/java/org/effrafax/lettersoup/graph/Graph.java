package org.effrafax.lettersoup.graph;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.effrafax.lettersoup.graph.clique.BronKerbosch;


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
		if(!contains(u) || !contains(v)) {
			throw new IllegalArgumentException("one of arguments is not a vertex.");
		}
		neighboursOf(u).add(v);
		neighboursOf(v).add(u);
	}

	private Set<T> neighboursOf(T vertex) {
		return neighbours.get(vertex);
	}

	public List<Set<T>> maximalCliques() {
		return BronKerbosch.maximalCliques(Collections.unmodifiableMap(neighbours));
	}
}
