package com.revature.eval.java.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EvaluationService {

	/**
	 * 1. Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 * 
	 * @param phrase
	 * @return
	 */
	public String acronym(String phrase) {
		String[] p = phrase.split("[\\W\\s]");
		String returner = "";
		for (String s : p) {
			if (!s.isEmpty())
				returner = returner + s.charAt(0);
		}
		return returner.toUpperCase();
	}

	/**
	 * 2. Given a word, compute the scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B,
	 * C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 * 
	 * @param string
	 * @return
	 */
	public int getScrabbleScore(String string) {

		if (!string.matches("([a-zA-Z])+"))
			throw new IllegalArgumentException();

		int score = 0;
		for (char c : (string.toUpperCase()).toCharArray()) {
			switch (c) {
			case 'D':
			case 'G':
				score += 2;
				break;
			case 'B':
			case 'C':
			case 'M':
			case 'P':
				score += 3;
				break;
			case 'F':
			case 'H':
			case 'V':
			case 'W':
			case 'Y':
				score += 4;
				break;
			case 'K':
				score += 5;
				break;
			case 'J':
			case 'X':
				score += 8;
				break;
			case 'Q':
			case 'Z':
				score += 10;
				break;
			default:
				score += 1;
			}
		}
		return score;
	}

	/**
	 * 3. Clean up user-entered phone numbers so that they can be sent SMS messages.
	 * 
	 * The North American Numbering Plan (NANP) is a telephone numbering system used
	 * by many countries in North America like the United States, Canada or Bermuda.
	 * All NANP-countries share the same international country code: 1.
	 * 
	 * NANP numbers are ten-digit numbers consisting of a three-digit Numbering Plan
	 * Area code, commonly known as area code, followed by a seven-digit local
	 * number. The first three digits of the local number represent the exchange
	 * code, followed by the unique four-digit number which is the subscriber
	 * number.
	 * 
	 * The format is usually represented as
	 * 
	 * 1 (NXX)-NXX-XXXX where N is any digit from 2 through 9 and X is any digit
	 * from 0 through 9.
	 * 
	 * Your task is to clean up differently formatted telephone numbers by removing
	 * punctuation and the country code (1) if present.
	 * 
	 * For example, the inputs
	 * 
	 * +1 (613)-995-0253 613-995-0253 1 613 995 0253 613.995.0253 should all produce
	 * the output
	 * 
	 * 6139950253
	 * 
	 * Note: As this exercise only deals with telephone numbers used in
	 * NANP-countries, only 1 is considered a valid country code.
	 */
	public String cleanPhoneNumber(String string) {

		if (!string.matches(
				"(\\s{0,}\\+?\\s{0,}1{1})?(\\s{0,}[\\.\\,\\- ]?\\s{0,})(\\(?[2-9]{1}[0-9]{2}\\)?)(\\s{0,}[\\.\\,\\- ]?\\s{0,})(\\(?[2-9]{1}[0-9]{2}\\)?)(\\s{0,}[\\.\\,\\- ]?\\s{0,})([0-9]{4})(\\s{0,})"))
			throw new IllegalArgumentException();

		return string.replaceAll("(\\+?[1])?(\\s{0,}[\\.\\,\\- \\(\\)\\s]?\\s{0,})+", "");
	}

	/**
	 * 4. Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 * 
	 * @param string
	 * @return
	 */
	public Map<String, Integer> wordCount(String string) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		String[] p = string.split("[\\W\\s]");
		for (String s : p) {
			if (!s.equals("")) {
				if (map == null || !map.containsKey(s))
					map.put(s, 1);
				else
					map.replace(s, map.get(s) + 1);
			}
		}
		return map;
	}

	/**
	 * 5. Implement a binary search algorithm.
	 * 
	 * Searching a sorted collection is a common task. A dictionary is a sorted list
	 * of word definitions. Given a word, one can find its definition. A telephone
	 * book is a sorted list of people's names, addresses, and telephone numbers.
	 * Knowing someone's name allows one to quickly find their telephone number and
	 * address.
	 * 
	 * If the list to be searched contains more than a few items (a dozen, say) a
	 * binary search will require far fewer comparisons than a linear search, but it
	 * imposes the requirement that the list be sorted.
	 * 
	 * In computer science, a binary search or half-interval search algorithm finds
	 * the position of a specified input value (the search "key") within an array
	 * sorted by key value.
	 * 
	 * In each step, the algorithm compares the search key value with the key value
	 * of the middle element of the array.
	 * 
	 * If the keys match, then a matching element has been found and its index, or
	 * position, is returned.
	 * 
	 * Otherwise, if the search key is less than the middle element's key, then the
	 * algorithm repeats its action on the sub-array to the left of the middle
	 * element or, if the search key is greater, on the sub-array to the right.
	 * 
	 * If the remaining array to be searched is empty, then the key cannot be found
	 * in the array and a special "not found" indication is returned.
	 * 
	 * A binary search halves the number of items to check with each iteration, so
	 * locating an item (or determining its absence) takes logarithmic time. A
	 * binary search is a dichotomic divide and conquer search algorithm.
	 * 
	 */
	static class BinarySearch<T> {
		private List<T> sortedList;

		public int indexOf(T t) {

			int index = sortedList.size() / 2, trackedIndex = 0;
			List<T> copyList = sortedList;

			while (index > -1 && index < copyList.size() && copyList.size() != 0) {
				int comparison = compare(copyList.get(index), t);
				if (comparison == 0) { // If it matches, return that index
					return trackedIndex + index;

				} else if (comparison < 0) {
					if (index == copyList.size() - 1) {
						return -1 * (trackedIndex + index + 2);
					}

					copyList = copyList.subList(index + 1, copyList.size());
					trackedIndex += index + 1;

				} else
					copyList = copyList.subList(0, index);

				index = copyList.size() / 2;
			}
			return -1 * (trackedIndex + index + 1);
		}

		public int compare(T a, T b) {
			if (a instanceof Number)
				return (Integer) a - (Integer) b;
			try {
				return Integer.parseInt((String) a) - Integer.parseInt((String) b);
			} catch (NumberFormatException e) {
				return ((String) a).compareTo((String) b);
			}
		}

		public BinarySearch(List<T> sortedList) {
			super();
			this.sortedList = sortedList;
		}

		public List<T> getSortedList() {
			return sortedList;
		}

		public void setSortedList(List<T> sortedList) {
			this.sortedList = sortedList;
		}

	}

	/**
	 * 6. An Armstrong number is a number that is the sum of its own digits each
	 * raised to the power of the number of digits.
	 * 
	 * For example:
	 * 
	 * 9 is an Armstrong number, because 9 = 9^1 = 9 10 is not an Armstrong number,
	 * because 10 != 1^2 + 0^2 = 2 153 is an Armstrong number, because: 153 = 1^3 +
	 * 5^3 + 3^3 = 1 + 125 + 27 = 153 154 is not an Armstrong number, because: 154
	 * != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190 Write some code to determine whether
	 * a number is an Armstrong number.
	 * 
	 * @param input
	 * @return
	 */
	public boolean isArmstrongNumber(int input) {
		int sumOfDigits = 0, power = Integer.toString(input).length();
		for (int i = 0; i < power; i++)
			sumOfDigits += Math.pow(Integer.parseInt(Integer.toString(input).substring(i, i + 1)), power);
		return sumOfDigits == input;
	}

	/**
	 * 7. Compute the prime factors of a given natural number.
	 * 
	 * A prime number is only evenly divisible by itself and 1.
	 * 
	 * Note that 1 is not a prime number.
	 * 
	 * @param l
	 * @return
	 */
	public List<Long> calculatePrimeFactorsOf(long l) {

		List<Long> primeFactors = new ArrayList<>();
		for (long i = 2; i < l; i++) {
			if ((l % i == 0) && (isPrime(i))) {
				long result = l;
				while (result % i == 0) {
					primeFactors.add(i);
					result /= i;
				}
			}
		}
		if (l <= 2) // Catch the case where the number is 2 or 1
			primeFactors.add(l);
		return primeFactors;
	}

	public boolean isPrime(long num) {
		for (long i = num - 1; i > 1; i--) {
			if (num % i == 0)
				return false;
		}
		return true;
	}

	/**
	 * 8-9. Create an implementation of the atbash cipher, an ancient encryption
	 * system created in the Middle East.
	 * 
	 * The Atbash cipher is a simple substitution cipher that relies on transposing
	 * all the letters in the alphabet such that the resulting alphabet is
	 * backwards. The first letter is replaced with the last letter, the second with
	 * the second-last, and so on.
	 * 
	 * An Atbash cipher for the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: zyxwvutsrqponmlkjihgfedcba It is a
	 * very weak cipher because it only has one possible key, and it is a simple
	 * monoalphabetic substitution cipher. However, this may not have been an issue
	 * in the cipher's time.
	 * 
	 * Ciphertext is written out in groups of fixed length, the traditional group
	 * size being 5 letters, and punctuation is excluded. This is to make it harder
	 * to guess things based on word boundaries.
	 * 
	 * Examples Encoding test gives gvhg Decoding gvhg gives test Decoding gsvjf
	 * rxpyi ldmul cqfnk hlevi gsvoz abwlt gives thequickbrownfoxjumpsoverthelazydog
	 *
	 */
	static class AtbashCipher {

		static Map<String, String> map = constructCipherMap();

		/**
		 * Question 8
		 * 
		 * @param string
		 * @return
		 */
		public static String encode(String string) {
			string = string.toLowerCase().replaceAll("\\s", "");

			String newString = "";

			for (int i = 0; i < string.length(); i++) {
				if (map.get(string.substring(i, i + 1)) != null) {
					if (((newString.length() + 1) % 6 == 0))
						newString = newString + " ";
					newString = newString + map.get(string.substring(i, i + 1));
				}
			}
			return newString;
		}

		public static Map<String, String> constructCipherMap() {
			Map<String, String> map = new HashMap<>();
			for (int i = 96; i < 123; i++)
				map.put(((char) i) + "", ((char) (122 - (i - 97))) + "");
			for (int i = 0; i < 10; i++)
				map.put(i + "", i + "");
			return map;
		}

		/**
		 * Question 9
		 * 
		 * @param string
		 * @return
		 */
		public static String decode(String string) {
			return encode(string).replaceAll(" ", "");
		}
	}

	/**
	 * 10. Parse and evaluate simple math word problems returning the answer as an
	 * integer.
	 * 
	 * Add two numbers together.
	 * 
	 * What is 5 plus 13?
	 * 
	 * 18
	 * 
	 * Now, perform the other three operations.
	 * 
	 * What is 7 minus 5?
	 * 
	 * 2
	 * 
	 * What is 6 multiplied by 4?
	 * 
	 * 24
	 * 
	 * What is 25 divided by 5?
	 * 
	 * 5
	 * 
	 * @param string
	 * @return
	 */
	public int solveWordProblem(String string) {
		// what is Integer (plus|added to|minus|subtracted by|multiplied by|divided by|) Integer ?
		if (!string.matches(
				"(\\s{0,1})(What)(\\s{0,1})(is)(\\s{0,1})(\\-?[0-9]{1,})(\\s{0,1})(plus|added\\s{0,1}to|minus|subtracted\\s{0,1}by|multiplied\\s{0,1}by|divided\\s{0,1}by)(\\s{0,1})(\\-?[0-9]{1,})(\\s{0,1})(\\?)?"))
			throw new IllegalArgumentException();

		List<String> entries = new ArrayList<String>(Arrays.asList((string.toLowerCase().split("(what|by|is|\\?| )"))));
		entries.removeAll(Arrays.asList(""));

		switch (entries.get(1)) {
		case "plus":
		case "added":
			return Integer.parseInt(entries.get(0)) + Integer.parseInt(entries.get(2));
		case "minus":
		case "subtracted":
			return Integer.parseInt(entries.get(0)) - Integer.parseInt(entries.get(2));
		case "multiplied":
			return Integer.parseInt(entries.get(0)) * Integer.parseInt(entries.get(2));
		case "divided":
			if (Integer.parseInt(entries.get(2)) == 0)
				throw new IllegalArgumentException();
			return Integer.parseInt(entries.get(0)) / Integer.parseInt(entries.get(2));
		default:
			throw new IllegalArgumentException();
		}
	}
}
