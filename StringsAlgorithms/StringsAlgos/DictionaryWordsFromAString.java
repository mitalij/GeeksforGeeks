import java.util.ArrayList;
import java.util.List;

public class DictionaryWordsFromAString {
	public static void main(String args[]) {
		List<String> dictionary = new ArrayList<>();
		/*dictionary.add("ale");
		dictionary.add("apple");
		dictionary.add("monkey");
		dictionary.add("plea");*/
		
		dictionary.add("a");
		dictionary.add("b");
		dictionary.add("c");
		
		String s = "abpcplea";
		System.out.println(findLongestWord(s, dictionary));
	}
	
	public static boolean isSubsequence(String dictionaryWord, String y) {
        int j = 0;
        for (int i = 0; i < y.length() && j < dictionaryWord.length(); i++)
            if (dictionaryWord.charAt(j) == y.charAt(i))
                j++;
        return j == dictionaryWord.length();
    }
    public static String findLongestWord(String s, List < String > d) {
        String max_str = "";
        for (String str: d) {
            if (isSubsequence(str, s)) {
                if (str.length() > max_str.length() || (str.length() == max_str.length() && str.compareTo(max_str) < 0))
                    max_str = str;
            }
        }
        return max_str;
    }
}
