package org.effrafax.lettersoup.graph;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.Collections;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class BronKerboschTest {

	private Graph<Integer> graph;
	
	@Before
	public void createGraph() {
		graph = new Graph<Integer>();
		
		graph.addVertex(1);
		graph.addVertex(2);
		graph.addVertex(3);
		graph.addVertex(4);
		graph.addVertex(5);
		graph.addVertex(6);
		
		graph.addEdge(1, 2);
		graph.addEdge(1, 5);
		graph.addEdge(2, 3);
		graph.addEdge(2, 5);
		graph.addEdge(3, 4);
		graph.addEdge(4, 5);
		graph.addEdge(4, 6);
	}

	@Test
	public void shouldSolveWikipediaExample() {
		Set<Integer> best = Collections.emptySet();
		for (Set<Integer> clique : graph.maximalCliques()) {
			if (clique.size() > best.size()) {
				best = clique;
			}
		}
		assertThat(best.size(), is(3));
		assertThat(best, hasItem(1));
		assertThat(best, hasItem(2));
		assertThat(best, hasItem(5));
	}
}
