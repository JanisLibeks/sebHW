package com.seb.io;

import com.seb.io.models.DictionaryModel;
import lombok.AllArgsConstructor;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class PredefienedDictionaryReader {
	public static final String EXAMPLE_DICTIONARY_PATH =
			System.getProperty("user.dir") + "\\src\\main\\resources\\input.txt";
	private List<DictionaryModel> dictionaryModelList;
	
	public List<DictionaryModel> saveDefaultFileToObject() {
		String line;
		File file = new File(EXAMPLE_DICTIONARY_PATH);
		dictionaryModelList = new ArrayList<>();
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			while ((line = reader.readLine()) != null) {
				dictionaryModelList.add(new DictionaryModel(line));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return dictionaryModelList;
	}
}
