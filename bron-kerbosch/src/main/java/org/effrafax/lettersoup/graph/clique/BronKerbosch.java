package org.effrafax.lettersoup.graph.clique;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BronKerbosch {
	public static <T> List<Set<T>> maximalCliques(Map<T, Set<T>> neighbours) {
		List<Set<T>> result = new ArrayList<Set<T>>();
		algorithm1(new HashSet<T>(), neighbours.keySet(), new HashSet<T>(), neighbours, result);
		return Collections.unmodifiableList(result);
	}
	
	private static <T> void algorithm1(Set<T> R, Set<T> P, Set<T> X, Map<T, Set<T>> neighbours, List<Set<T>> result) {
		if (P.isEmpty() && X.isEmpty()) {
			result.add(Collections.unmodifiableSet(R));
		}
		while (!P.isEmpty()) {
			T vertex = pickFrom(P);
			Set<T> neighbourhood = neighbours.get(vertex);
			algorithm1(union(R, vertex), intersection(P, neighbourhood), intersection(X, neighbourhood), neighbours, result);
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
}
