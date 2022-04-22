import java.util.Locale;

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
