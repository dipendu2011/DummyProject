package com.example.demo.base.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.util.UUID;

public class CommonUtils {

	Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");

	public static boolean isEmpty(String str) {
		return str == null || str.length() == 0;
	}

	public static boolean isEmpty(UUID id) {
		// TODO Auto-generated method stub
		return id == null;
	}

	public static boolean check(String name) {
		// TODO Auto-generated method stub
		Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");

		Matcher matcher = pattern.matcher(name);
		boolean isStringContainsSpecialCharacter = matcher.find();

		return isStringContainsSpecialCharacter;
	}

}
