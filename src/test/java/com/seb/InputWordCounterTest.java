package com.seb;

import com.seb.io.PredefienedDictionaryReader;
import com.seb.io.models.DictionaryModel;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class InputWordCounterTest {
	
	private final List<DictionaryModel> dictionaryModelList =
			new PredefienedDictionaryReader(new ArrayList<>()).saveDefaultFileToObject();
	
	@Test
	public void count_should_be_two_if_one_word_from_dictionary_contains_two() {
		String testString = "can 213123wqe";
		assertEquals(2, new InputWordCounter(testString, dictionaryModelList).count());
	}
	
	@Test
	public void count_should_be_one_if_only_one_word_from_dictionary_is_in_string() {
		String testString = "qwas of asq";
		assertEquals(1, new InputWordCounter(testString, dictionaryModelList).count());
	}
	
	@Test
	public void count_should_be_zero_if_no_words_from_dictionary_found() {
		String testString = "qazxswedcvfr";
		assertEquals(0, new InputWordCounter(testString, dictionaryModelList).count());
	}
	
	@Test
	public void count_should_be_zero_if_input_contains_two_words_in_uppercase() {
		String testString = "aqwsANozaABLE";
		assertEquals(0, new InputWordCounter(testString, dictionaryModelList).count());
	}
	
	@Test
	public void count_should_be_three_if_one_word_from_dictionary_is_present_three_times() {
		String testString = "of qwea of qasd of asde";
		assertEquals(3, new InputWordCounter(testString, dictionaryModelList).count());
	}
	
	@Test
	public void count_should_be_zero_if_string_contains_word_from_dictionary_with_space_in_middle() {
		String testString = "qasdew lo g ewqasd";
		assertEquals(0, new InputWordCounter(testString, dictionaryModelList).count());
	}
}