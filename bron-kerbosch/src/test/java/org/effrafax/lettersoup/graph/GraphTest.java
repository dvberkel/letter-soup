package org.effrafax.lettersoup.graph;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

import org.effrafax.lettersoup.word.Word;
import org.junit.Test;

public class GraphTest {

	@Test
	public void shouldBeAbleToCreateEmptyGraph() {
		Graph<Word> emptyGraph = new Graph<Word>();
		
		assertThat(emptyGraph, is(notNullValue()));
	}

	@Test
	public void shouldBeAbleToCreateDisjointGraph() {
		Graph<Word> disjointGraph = new Graph<Word>();
		
		disjointGraph.addVertex(new Word("ABBOT"));
		disjointGraph.addVertex(new Word("RICE"));
		disjointGraph.addVertex(new Word("BROTHEL"));
		
		assertThat(disjointGraph, is(notNullValue()));
	}

	@Test
	public void shouldBeAbleToCreateCompleteGraph() {
		Graph<Word> completeGraph = new Graph<Word>();
		
		completeGraph.addVertex(new Word("ABBOT"));
		completeGraph.addVertex(new Word("RICE"));
		completeGraph.addVertex(new Word("BROTHEL"));
		
		completeGraph.addEdge(new Word("ABBOT"), new Word("RICE"));
		completeGraph.addEdge(new Word("RICE"), new Word("BROTHEL"));
		completeGraph.addEdge(new Word("BROTHEL"), new Word("ABBOT"));
		
		assertThat(completeGraph, is(notNullValue()));
	}

	@Test(expected=IllegalArgumentException.class)
	public void shouldNotBeAbleToAddAnEdgeForNonExistingVertex() {
		Graph<Word> graph = new Graph<Word>();
		
		graph.addVertex(new Word("ABBOT"));
		
		graph.addEdge(new Word("ABBOT"), new Word("RICE"));
	}

}
