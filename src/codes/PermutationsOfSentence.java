/**
 * 
 */
package codes;

import java.util.ArrayList;
import java.util.List;

public class PermutationsOfSentence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		getAllPermutationsOfTerms("My name is Sumit");
	}
	
    private static void getAllPermutationsOfTerms(String baseTerm) {
		List<String> allPermutations = new ArrayList<String>();
		String[] termStringArray = baseTerm.split(" ");
		StringBuffer sizeStr =  new StringBuffer();
		for(int i = 0; i<termStringArray.length; i++) {
			sizeStr.append(i);
		}
		collectAllPermuations(sizeStr.toString(), "", allPermutations, termStringArray);
		for(String s : allPermutations) {
			System.out.println(s);
		}
	}


	private static void collectAllPermuations(String str, String permuationsOfArrayIndices, List<String> allPermutations, String[] termStringArray) {
		if (str.length() == 0) {
			StringBuffer permuatation = new StringBuffer();
			char[] charArray = permuationsOfArrayIndices.toCharArray();
			for(int i = 0; i<charArray.length; i++) {
				permuatation.append(termStringArray[Integer.parseInt(String.valueOf(charArray[i]))]);
				if(i < charArray.length-1)
					permuatation.append(" ");
			}
			allPermutations.add(permuatation.toString());
			return;
		}
  
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			String restOfString = str.substring(0, i) +  str.substring(i + 1);
			collectAllPermuations(restOfString, permuationsOfArrayIndices + ch, allPermutations, termStringArray);
		}
	}
}
