package com.seb;

import com.seb.io.models.DictionaryModel;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class InputWordCounter {
	private final String input;
	private final List<DictionaryModel> dictionaryModels;
	
	public int count() {
		List<Integer> countList = new ArrayList<>();
		
		dictionaryModels.forEach(item -> {
			String testString = input;
			int count = 0;
			while (testString.contains(item.getWordFromDicionary())) {
				testString = testString.replaceFirst(item.getWordFromDicionary(), "");
				count++;
			}
			countList.add(count);
		});
		return countList.stream().mapToInt(Integer::intValue).sum();
	}
}
