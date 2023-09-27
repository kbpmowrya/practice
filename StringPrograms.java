package com.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Predicate;
import java.util.Set;
import java.util.stream.Collectors;
//https://www.youtube.com/watch?v=RMRkK3rF1OU&t=1449s
//https://www.youtube.com/watch?v=jid3mgqrZFQ&list=PLON_-G-h6YHX_EpzrCPvcJcWfLtHy6j9N     
public class StringPrograms {

	public static void main(String[] args) {
		String str = "abcdabcdabcdx";
//		Q1. Reverse string
//			M1. Using toCharArrayy() method
			Q1_M1(str);
//			M2.	Using charAt(int Index) method
			Q1_M2(str);
//			M3. Using StringBuffer's reverse Method
			Q1_M3(str);
//			M4. Using StringBuilder's reverse Method
			Q1_M4(str);
//			M5.
			Q1_M5_reverseString(str);
//		2. Remove duplicate chars
//			M1. 
			Q2_M1(str);
//			M2.
			Q2_M2(str);
//			M3. 
			Q2_M3(str);
//			M4. 
			Q2_M4(str);
//	        Write a java program to remove repeated charaters from the given string 
	        Q2_M5_removeRepeatedCharacters(str);
	        
//		3. Reverse Each Word in String
			Q3_M1();
//		4. Find/count Char Occurrence of each character in given String
			Q4_M1(str);
			Q4_M2(str);// java8 streams
//			Count The Number of Occurrences of a Specific Character in a String
			Q4_M3(str,'j');
			Q4_M4(str,'j');
//		5. Find Non Repeated Char
//	        Write a java program to print non repeated charaters from the given string
			Q5_M1(str);
			Q5_M2(str);
	        Q5_M3_findNonRepeatedCharacters(str);
	        //First non-repeating character : 
	        Q5_M4_findFirstNonRepeatingChar(str);
//		6. Replace Char with Occurrence Input: OPENTEXT and Output: OPEN1EX2
			String input = "OPENTEXT";
			Q6_M1(input);
			Q6_M2(input);
//		7. Find Longest Substring Input:abbac Output:bac --> Length is 3 ; Input:abcabcbb Output:abc --> Length is 3
			String s = "abbac";
			Q7_M1(s);
//		8. Sort String Characters
			//M1: Without using sort method
			String sortString = "java";
			Q8_M1(sortString);
			//M2: Using sort method
			Q8_M2(sortString);
//		9. Remove Whitespaces in String Input: ja va st a r Outside: javastar
			String spaceStr = " ja va st a r ";
			Q9_M1(spaceStr);
			
//		10. Remove Special Characters
			String splStr = "Ja**v#a$";
//			M1:
			Q10_M1(splStr);
//			M2:
//			https://www.youtube.com/watch?v=rrNxdiFtbfk
			Q10_M2(splStr);
	        String input1 = "java";
	        System.out.println("Original string: " + input1);
//	      11.Given a list of integers, find out all the numbers starting with 1 using Stream functions? 
	      //Input - {2, 11, 34, 45, 19, 1, 67, 87, 23, 105}, Output - 11, 19, 1, 105
              Q11_M1_NumberStartsWith();
//          12.Java Program to Remove All Vowels from a String( https://www.youtube.com/watch?v=eSYJZBX2XEo )
              Q12_M1(spaceStr);
//          13.Java Program to Count Digits, Letters, Whitespace, and Special Characters in a String (https://www.youtube.com/watch?v=iOn5TCKmE8o)
              String strCnt = "!@#$$ Test 232 Auto mation )(^ Java";
              Q13_M1(strCnt);
              Q13_M2(strCnt);
              Q13_M3(strCnt);
	          }
    public static void Q13_M3(String inputString) {

      long letterCount = countChars(inputString, Character::isLetter);
      long digitCount = countChars(inputString, Character::isDigit);
      long whitespaceCount = countChars(inputString, Character::isWhitespace);
      long specialCharCount = countChars(inputString, c -> !Character.isLetterOrDigit(c) && !Character.isWhitespace(c));

      System.out.println("Letter count: " + letterCount);
      System.out.println("Digit count: " + digitCount);
      System.out.println("Whitespace count: " + whitespaceCount);
      System.out.println("Special character count: " + specialCharCount);
  }

  public static long countChars(String input, Predicate<Character> predicate) {
      return input.chars()
              .mapToObj(ch -> (char) ch)
              .filter(predicate)
              .count();
  }
  public static void Q13_M2(String text) {

      long lettersCount = text.chars()
              .filter(Character::isLetter)
              .count();

      long digitsCount = text.chars()
              .filter(Character::isDigit)
              .count();

      long whitespacesCount = text.chars()
              .filter(Character::isWhitespace)
              .count();

      long specialCharactersCount = text.chars()
              .filter(c -> !Character.isLetter(c) && !Character.isDigit(c) && !Character.isWhitespace(c))
              .count();

      System.out.println("The number of letters is: " + lettersCount);
      System.out.println("The number of digits is: " + digitsCount);
      System.out.println("The number of whitespaces is: " + whitespacesCount);
      System.out.println("The number of special characters is: " + specialCharactersCount);
  }
	private static void Q13_M1(String str) {
		int digits = 0, whitespace = 0, letters = 0, special = 0;
		for(char c: str.toCharArray() ){
		if(Character.isLetter(c)){
			letters++;
		}else if(Character.isDigit(c)){
			digits++;
		}else if(Character.isWhitespace(c)){
			whitespace++;
		}else{
			special++;
		}
		}
		System.out.println("White space: "+whitespace);
		System.out.println("digits: "+digits);
		System.out.println("letters: "+letters);
		System.out.println("special: "+special);
	}
	private static void Q12_M1(String spaceStr) {
		StringBuilder outStr = new StringBuilder();
		  String vowels = "aeiouAEIOU";
		  for(char c: spaceStr.toCharArray()){
			  if(vowels.indexOf(c)==-1){
				  outStr.append(c);
			  }
		  }
		  System.out.println(outStr.toString());
	}
	private static void Q11_M1_NumberStartsWith() {
		List<Integer> numbers = Arrays.asList(123, 234, 156, 178, 105, 612, 789);

		      List<Integer> numbersStartingWithOne = numbers.stream()
		              .filter(number -> String.valueOf(number).startsWith("1"))
		              .collect(Collectors.toList());

		      System.out.println("Numbers starting with 1: " + numbersStartingWithOne);
	}

	public static void Q4_M4(String input,char ch){
		long count1 = input.chars().mapToObj(c -> (char)c).filter(c -> c == ch).count();
		System.out.println(count1);
	};
	public static void Q4_M3(String input,char ch){
		int count =0;
		for(char c:input.toCharArray()){
			if(c==ch){
				count++;
			}			
		}
		System.out.println(count);
	}
    public static void Q5_M4_findFirstNonRepeatingChar(String input) {
        Map<Character, Integer> charCountMap = new LinkedHashMap<>();

        input.chars()
             .mapToObj(c -> (char) c)
             .forEach(c -> charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1));

        char firstNonRepeatingChar = charCountMap.entrySet().stream()
                           .filter(entry -> entry.getValue() == 1)
                           .map(Map.Entry::getKey)
                           .findFirst()
                           .orElse('\0'); // Return null character if no non-repeating character found
        System.out.println("First non-repeating character: " + firstNonRepeatingChar);
    }

    public static void Q1_M5_reverseString(String input) {
        String reversed = new StringBuilder(input)
                .reverse()
                .chars()
                .mapToObj(c -> (char) c)
                .map(Object::toString)
                .collect(Collectors.joining());
        System.out.println("Reversed string: " + reversed);
    }
	private static void Q7_M1(String s) {
		String longestSubstring = null;
		int longestSubstringLength = 0;
		Map<Character, Integer> map = new LinkedHashMap<Character, Integer>();
		char[] arr = s.toCharArray();
		for(int i = 0; i < arr.length; i++){
			char ch = arr[i];
			if(!map.containsKey(ch)){
				map.put(ch, i);
			}else{
				i = map.get(ch);
				map.clear();
			}
			if(map.size() > longestSubstringLength){
				longestSubstringLength = map.size();
				longestSubstring = map.keySet().toString();
				
			}
		}
		System.out.println("The longest substrging: "+longestSubstring);
		System.out.println("The longest substrging length : "+longestSubstringLength);
	}
	    
	    public static void Q2_M5_removeRepeatedCharacters(String input) {
	        LinkedHashSet<Character> uniqueCharacters = new LinkedHashSet<>();
	        StringBuilder result = new StringBuilder();
	        
	        for (char c : input.toCharArray()) {
	            if (uniqueCharacters.add(c)) {
	                result.append(c);
	            }
	        }
	        System.out.println("String with repeated characters removed: " + result.toString());
	    }
	    public static void Q5_M3_findNonRepeatedCharacters(String input) {
	        Map<Character, Integer> charFrequency = new HashMap<>();
	        
	        for (char c : input.toCharArray()) {
	            charFrequency.put(c, charFrequency.getOrDefault(c, 0) + 1);
	        }
	        
	        StringBuilder nonRepeatedChars = new StringBuilder();
	        
	        for (char c : input.toCharArray()) {
	            if (charFrequency.get(c) == 1) {
	                nonRepeatedChars.append(c);
	            }
	        }
	        System.out.println("Non-repeated characters: " + nonRepeatedChars.toString());
	    }

	private static void Q10_M1(String splStr) {
		String resStr = splStr.replaceAll("[^a-zA-Z0-9]", "");
		System.out.println(resStr);
	}

	private static void Q10_M2(String splStr) {
		char[] charArry = splStr.toCharArray();
		StringBuilder sb = new StringBuilder();
		for(char ch:charArry){
			if(Character.isLetter(ch)){
				sb.append(ch);
			}
		}
		System.out.println(sb.toString());
	}

	private static void Q1_M4(String str) {
		StringBuilder strBld = new StringBuilder(str);
		System.out.println(strBld.reverse());
	}

	private static void Q1_M3(String str) {
		StringBuffer strBuff = new StringBuffer(str);
		System.out.println(strBuff.reverse());
	}

	private static void Q1_M2(String str) {
		StringBuilder fnlStr = new StringBuilder();
		for(int i= str.length()-1; i >=0;i--){
			fnlStr.append((char)str.charAt(i));
		}
		System.out.println(fnlStr.toString());
	}

	private static void Q1_M1(String str) {
		char[] arr1 = str.toCharArray();
		StringBuilder fnlStr = new StringBuilder();
		for(int i=arr1.length-1; i >= 0; i--){
			fnlStr.append(arr1[i]);
		}
		System.out.println(fnlStr.toString());
	}

	private static void Q9_M1(String spaceStr) {
		spaceStr = spaceStr.replaceAll("\\s", "");
		System.out.println(spaceStr);
	}

	private static void Q8_M2(String sortString) {
		char[] arr2 = sortString.toCharArray();
		Arrays.sort(arr2);
		System.out.println(arr2);
	}

	private static void Q8_M1(String sortString) {
		char temp;
		char[] arr1 = sortString.toCharArray();
		for(int i=0; i < arr1.length; i++){
			for(int j=i+1; j < arr1.length; j++){
				if(arr1[i] > arr1[j]){
					temp = arr1[i];
					arr1[i] = arr1[j];
					arr1[j] = temp;						
				}
			}
		}
		System.out.println(arr1);
	}

	private static void Q6_M2(String input) {
		int cnt = 1;
		for(int i=0; i < input.length();i++){
			char ch = input.charAt(i);
			if(ch == 'T'){
				input = input.replaceFirst(String.valueOf('T'), String.valueOf(cnt));
				cnt++;
			}
		}
		System.out.println(input);
	}

	private static void Q6_M1(String input) {
		int cnt=1;
		char charToReplace = 'T';
		char[] chars = input.toCharArray();
		if(input.indexOf(charToReplace) == -1){
			System.out.println("Given character not available In Input String...");
			System.exit(0);
		}
		for(int i =0; i < chars.length; i++){
			if(chars[i] == charToReplace){
				chars[i] = String.valueOf(cnt).charAt(0);
				cnt++;
			}
		}
		System.out.println(Arrays.toString(chars));
	}

	private static void Q5_M2(String str) {
		Map<Character, Integer> map = new HashMap();
		for(int i=0; i < str.length(); i++){
			char ch = (char)str.charAt(i);
			if(!map.containsKey(ch)){
				map.put(ch, 1);
			}else{
				map.put(ch, map.get(ch)+1);
			}
		}
//			System.out.println(map);
		for(Entry<Character, Integer> entrySet : map.entrySet()){
			if(entrySet.getValue() == 1){
				System.out.println(entrySet.getKey());
			}
		}
	}

	private static void Q5_M1(String str) {
		for(int i =0; i < str.length(); i++){
			boolean unique = true;
			for(int j = 0; j < str.length(); j++){
				if(i != j && str.charAt(i) == str.charAt(j)){
				unique = false;
				}
			}
			if(unique){
				System.out.println(((char)str.charAt(i)));
				break;
			}
		}
	}

	private static void Q4_M2(String str) {
		Map<Character, Integer> map = new HashMap();
		str.chars().mapToObj(ch -> (char)ch).forEach(ch -> map.put(ch, map.getOrDefault(ch, 0)+1));
		System.out.println(map);
	}
	private static void Q4_M1(String str) {
		Map<Character, Integer> map = new HashMap();
		char[] chars = str.toCharArray();
		for(char ch:chars){
			if(!map.containsKey(ch)){
				map.put(ch, 1);
			}else{
				int value = map.get(ch);
				map.put(ch, value+1);
			}
		}
		System.out.println(map);
	}

	private static void Q3_M1() {
		String str2 = "Java Code";
		StringBuilder sb5 = new StringBuilder();
		for(String echStr: str2.split(" ")){
			String output = reverseString(echStr);
			sb5.append(output+" ");
		}
		System.out.println(sb5.toString());
	}

	private static String reverseString(String echStr) {
		StringBuilder sb = new StringBuilder();
		for(int i=echStr.length()-1; i >= 0; i--){
			int c = echStr.charAt(i);//It return ASCII number 
			sb.append((char)c);
		}
		return sb.toString();
	}

	private static void Q2_M4(String str) {
		StringBuilder sb4 = new StringBuilder();
		Set<Character> set = new LinkedHashSet();
		for(int i=0; i < str.length(); i++){
			set.add(str.charAt(i));
		}
		for(Character c:set){
			sb4.append(c);
		}
		System.out.println(sb4.toString());
	}

	private static void Q2_M3(String str) {
		char[] arr = str.toCharArray();
		StringBuilder sb3 = new StringBuilder();
		for(int i = 0; i < arr.length; i++){
			boolean repeated = false;
			for(int j = i +1; j < arr.length; j++){
				if(arr[i] == arr[j]){
					repeated = true;
					break;
				}
			}
			if (!repeated){
				sb3 = sb3.append(arr[i]);
			}
		}
		System.out.println(sb3);
	}

	private static void Q2_M2(String str) {
		StringBuilder sb2 = new StringBuilder();
		for(int i=0; i < str.length(); i++){
			char ch = str.charAt(i);
			int idx = str.indexOf(ch,i+1); // if ch index values not mathc with i+1 then it return -1
			if(idx == -1){
				sb2.append(ch);
			}
		}
		System.out.println(sb2);
	}

	private static void Q2_M1(String str) {
		StringBuilder sb1 = new StringBuilder();
		str.chars().distinct().forEach(c -> sb1.append((char)c));
		System.out.println(sb1);
	}

}
