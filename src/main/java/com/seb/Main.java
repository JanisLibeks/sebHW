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
	static List<DictionaryModel> dictionaryModels;
	
	public static void main(String[] args) {
		String input = "";
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		dictionaryModels = new PredefienedDictionaryReader(new ArrayList<>()).saveDefaultFileToObject();
		while (!"Q".equals(input)) {
			out.println("To exit type \"Q\" and press Enter. \n Please provide input string: ");
			try {
				input = reader.readLine();
				out.println("Count of words found from dictionary: " +
						new InputWordCounter(input, dictionaryModels).count());
			} catch (IOException e) {
				out.println("Invalid input, try again!");
			}
		}
	}
}
