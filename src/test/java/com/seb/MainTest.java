package com.seb;

import com.seb.io.models.DictionaryModel;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class MainTest {
	
	@Test
	public void should_make_first_input_and_object_array_values_lowercase() {
		Main.inputFirst = "UPPERCASE";
		Main.dictionaryModels = new ArrayList<>();
		Main.dictionaryModels.add(new DictionaryModel("UPPERCASE"));
		
		Main.allRecoursesToLowercase();
		
		assertEquals("uppercase", Main.inputFirst);
		assertEquals("uppercase", Main.dictionaryModels.get(0).getWordFromDicionary());
	}
}