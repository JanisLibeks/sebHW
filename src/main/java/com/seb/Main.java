package com.seb;

import com.seb.io.PredefienedDictionaryReader;
import com.seb.io.models.DictionaryModel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.*;

public class Main {
	static List<DictionaryModel> dictionaryModels
			= new PredefienedDictionaryReader(new ArrayList<>()).saveDefaultFileToObject();
	static String inputFirst = "";
	static String inputSecond = "";
	
	public static void main(String[] args) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		while (!"Q".equals(inputFirst)) {
			try {
				out.println("\n\nTo exit type \"q\" and press Enter. \n 1.Please provide input string: ");
				inputFirst = reader.readLine();
				
				out.println("By default search is case sensitive. If you want to ignore case type \"y\" and Enter.");
				inputSecond = reader.readLine();
				
				if ("y".equals(inputSecond)) {
					allRecoursesToLowercase();
				}
				
				out.println("Count of words found from dictionary: " +
						new InputWordCounter(inputFirst, dictionaryModels).count());
			} catch (IOException e) {
				out.println("Invalid input, try again!");
			}
		}
	}
	
	static void allRecoursesToLowercase() {
		inputFirst = inputFirst.toLowerCase();
		dictionaryModels.forEach(item -> item.setWordFromDicionary(item.getWordFromDicionary().toLowerCase()));
	}
}
