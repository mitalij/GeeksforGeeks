import java.util.HashMap;
import java.util.Map;

//First Thought : 
/*Create a char count array / map. Then traverse the string again, and find the first element whose count is 1.
In this, if the string is huge, and the unique character is at last, it would result in unnecessary iteration.*/

public class FirstNonRepeatingCharacterInString {
	
	static class CountWithIndex { 
	    int count,index; 
	      
	    // constructor for first occurrence 
	    public CountWithIndex(int index) { 
	        this.count = 1; 
	        this.index = index; 
	    } 
	      
	    // method for updating count 
	    public void incrementCount() { 
	        this.count++; 
	    } 
	}

	public static void main(String[] args) {
		//This approach is helpful for the below string, if we traverse the string again, it would be too much (where the first unique char is the last element)
		//String s = "aabbgggggggggggggggggggggggtttttttttttttttttwwwwwwwwwwwwwwwwwwwuuuuuuuuuuuuuuuuuuuz";
		String s = "ab";
		System.out.println("Length of string : " + s.length());
		System.out.println(firstNonRepeatingString(s));
	}
	
	static char firstNonRepeatingString(String word) {
		Map<Character, CountWithIndex> frequencyMap = createHashMapWithCount(word);
		int result = Integer.MAX_VALUE;
		
		for (CountWithIndex frequency : frequencyMap.values()) {
			if(frequency.count == 1) {
				result = Math.min(result, frequency.index);
			}
		}
		return word.charAt(result);
	}

	static Map<Character, CountWithIndex> createHashMapWithCount(String word) {
		Map<Character, CountWithIndex> frequencyMap = new HashMap<>();
		for (int i = 0; i < word.length(); i++) {
			if(frequencyMap.get(word.charAt(i)) != null) {
				frequencyMap.get(word.charAt(i)).incrementCount();
			} else {
				frequencyMap.put(word.charAt(i), new CountWithIndex(i));
			}
		}
		return frequencyMap;
	}
	
	

}
