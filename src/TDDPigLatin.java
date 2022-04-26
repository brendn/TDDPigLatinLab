import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TDDPigLatin {

    private static final String VOWELS = "aeiou";

    /**
     * Translates the given word to Pig Latin.
     * 
     * @param word Input word
     * @return The input word in pig latin
     */
    public static String translate(String word) {
        word = word.toLowerCase(Locale.ROOT);
        if (!hasVowels(word)) return word;
        if (isVowel(word.charAt(0))) return word + "way";
        int vowel = -1;

        for (char c : word.toCharArray()) {
            if (isVowel(c)) {
                vowel = word.indexOf(c);
                break;
            }
        }

        return word.substring(vowel) + word.substring(0, vowel) + "ay";
    }
    
    /**
     * Translates the given phrase to Pig Latin.
     * 
     * @param phrase Input phrase
     * @return The input phrase translated to Pig Latin.
     */
    public static String translatePhrase(String phrase) {
    	//Check for words
    	Matcher matcher = Pattern.compile("\\p{L}+").matcher(phrase);
    	StringBuffer buffer = new StringBuffer();
    	
    	//For each word, translate to Pig Latin
    	while (matcher.find()) {
    		String s = matcher.group();
    		if (!hasNumber(s) && !hasSymbol(s)) {
        		matcher.appendReplacement(buffer, translate(s));
    		}
    	}
    	
    	matcher.appendTail(buffer);
    	
    	//Return translated phrase
    	return buffer.toString();
    }
    
    /**
     * Checks whether or not the given String contains a symbol.
     * 
     * @param s Input string
     * @return True if the String contains a symbol.
     */
    public static boolean hasSymbol(String s) {
    	Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
    	Matcher m = p.matcher(s);
    	return m.find();
    }
    
    /**
     * Checks whether or not the given String contains a number.
     * 
     * @param s Input string
     * @return True if the String contains a number.
     */
    public static boolean hasNumber(String s) {
        return s.matches(".*[0-9].*");
    }

    /**
     * Checks if the input String contains vowels
     * 
     * @param input Input string
     * @return true if a vowel is found, otherwise false
     */
    public static boolean hasVowels(String input) {
        for (char c : input.toCharArray()) {
            if (isVowel(c)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if the input character is a vowel.
     * 
     * @param c input character to check
     * @return true if the character is a vowel, false otherwise
     */
    public static boolean isVowel(char c) {
        return VOWELS.contains(String.valueOf(c));
    }
}
