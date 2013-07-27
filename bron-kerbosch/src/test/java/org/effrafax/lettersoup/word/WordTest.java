package org.effrafax.lettersoup.word;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class WordTest {
	@Test(expected=IllegalArgumentException.class)
	public void shouldBeConstructedWithANonNullWord() {
		new Word(null);
	}
		
	@Test
	public void shouldHaveAMeaningfullEquality() {
		Word word = new Word("ABBOT");
		Word other = new Word("ABBOT");
		
		assertThat(word, is(equalTo(other)));		
	}

	@Test
	public void shouldBeCaseInsensitive() {
		Word word = new Word("ABBOT");
		Word other = new Word("abbot");
		
		assertThat(word, is(equalTo(other)));		
	}
}
