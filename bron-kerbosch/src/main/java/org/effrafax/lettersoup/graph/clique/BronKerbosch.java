package org.effrafax.lettersoup.graph.clique;

import java.util.*;

public class BronKerbosch {
	public static <T> List<Set<T>> maximalCliques(Map<T, Set<T>> neighbours) {
		List<Set<T>> result = new ArrayList<Set<T>>();
		degeneracy(new HashSet<T>(), vertices(neighbours), new HashSet<T>(), neighbours, result);
		return Collections.unmodifiableList(result);
	}

	private static <T> Set<T> vertices(Map<T, Set<T>> neighbours) {
		Set<T> vertices = new HashSet<T>();
		vertices.addAll(neighbours.keySet());
		return vertices;
	}
	
	@SuppressWarnings("unused")
	private static <T> void naive(Set<T> R, Set<T> P, Set<T> X, Map<T, Set<T>> neighbours, List<Set<T>> result) {
		if (P.isEmpty() && X.isEmpty()) {
			result.add(Collections.unmodifiableSet(R));
		}
		while (!P.isEmpty()) {
			T vertex = pickFrom(P);
			Set<T> neighbourhood = neighbours.get(vertex);
			naive(union(R, vertex), intersection(P, neighbourhood), intersection(X, neighbourhood), neighbours, result);
			P.remove(vertex);
			X.add(vertex);			
		}
	}
	
	private static <T> T pickFrom(Set<T> A) {
		return A.iterator().next();
	}
	
	private static <T> Set<T> union(Set<T> A, Set<T> B) {
		Set<T> result = new HashSet<T>();
		result.addAll(A);
		result.addAll(B);
		return result;
	}
	
	private static <T> Set<T> union(Set<T> A, T b) {
		Set<T> result = new HashSet<T>();
		result.addAll(A);
		result.add(b);
		return result;
	}
	
	private static <T> Set<T> intersection(Set<T> A, Set<T> B) {
		Set<T> result = new HashSet<T>();
		result.addAll(A);
		result.retainAll(B);
		return result;
	}
	
	private static <T> Set<T> minus(Set<T> A, Set<T> B) {
		Set<T> result = new HashSet<T>();
		result.addAll(A);
		result.removeAll(B);
		return result;
	}
	
	private static <T> void pivot(Set<T> R, Set<T> P, Set<T> X, Map<T, Set<T>> neighbours, List<Set<T>> result) {
		if (P.isEmpty() && X.isEmpty()) {
			result.add(Collections.unmodifiableSet(R));
		} else {
			T pivot = pickFrom(union(P,X));
			Set<T> candidates = minus(P, neighbours.get(pivot));
			for (T vertex : candidates) {
				Set<T> neighbourhood = neighbours.get(vertex);
				pivot(union(R, vertex), intersection(P, neighbourhood), intersection(X, neighbourhood), neighbours, result);
				P.remove(vertex);
				X.add(vertex);			
			}
		}
	}

    private static <T> void degeneracy(Set<T> R, Set<T> P, Set<T> X, Map<T, Set<T>> neighbours, List<Set<T>> result) {
        for (T vertex : degeneracyOrder(neighbours)) {
            Set<T> neighbourhood = neighbours.get(vertex);
            pivot(union(R, vertex), intersection(P, neighbourhood), intersection(X, neighbourhood), neighbours, result);
            P.remove(vertex);
            X.add(vertex);
        }
    }

    private static <T> List<T> degeneracyOrder(Map<T, Set<T>> neighbours) {
        List<T> degeneracyOrder = new ArrayList<T>();
        degeneracyOrder.addAll(neighbours.keySet());
        Collections.sort(degeneracyOrder, new DegeneracyOrderComparator<T>(neighbours));
        return degeneracyOrder;
    }
}

class DegeneracyOrderComparator<T> implements Comparator<T> {

    private Map<T, Set<T>> neighbours;

    public DegeneracyOrderComparator(Map<T, Set<T>> neighbours) {
        this.neighbours = neighbours;
    }

    @Override
    public int compare(T u, T v) {
        return neighbours.get(u).size() - neighbours.get(v).size();
    }

}
