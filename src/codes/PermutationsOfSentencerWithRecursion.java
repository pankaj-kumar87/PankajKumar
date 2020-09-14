/**
 * 
 */
package codes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * This program accepts a string and prints all possible permutations of the
 * words in the sentence. This uses recursion.
 *
 */
public class PermutationsOfSentencerWithRecursion {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String inputSentence = null;
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter your sentence");
			inputSentence = String.valueOf(br.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		}
		long currentTime = System.currentTimeMillis();
		getAllPermutationsOfTerms(inputSentence);
		System.out.println("Total Time Taken is " + (System.currentTimeMillis() - currentTime)/1000 + " seconds");
	}

	private static void getAllPermutationsOfTerms(String baseTerm) {
		List<String> allPermutations = new ArrayList<String>();
		String[] termStringArray = baseTerm.split(" ");
		StringBuffer sizeStr = new StringBuffer();
		for (int i = 0; i < termStringArray.length; i++) {
			sizeStr.append(i);
		}
		collectAllPermuations(sizeStr.toString(), "", allPermutations, termStringArray);
		for (String s : allPermutations) {
			System.out.println(s);
		}
	}

	private static void collectAllPermuations(String str, String permuationsOfArrayIndices,
			List<String> allPermutations, String[] termStringArray) {
		if (str.length() == 0) {
			StringBuffer permuatation = new StringBuffer();
			char[] charArray = permuationsOfArrayIndices.toCharArray();
			for (int i = 0; i < charArray.length; i++) {
				permuatation.append(termStringArray[Integer.parseInt(String.valueOf(charArray[i]))]);
				if (i < charArray.length - 1)
					permuatation.append(" ");
			}
			allPermutations.add(permuatation.toString());
			return;
		}

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			String restOfString = str.substring(0, i) + str.substring(i + 1);
			collectAllPermuations(restOfString, permuationsOfArrayIndices + ch, allPermutations, termStringArray);
		}
	}
}
