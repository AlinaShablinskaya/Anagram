package ua.com.foxminded.anagrams;

public class AnagramCreater {
    
    private static final String SPACE_DELIMITER = " ";
    
    public String createAnagram(String sentence) {
        validateSentence(sentence);
        
        String[] words = sentence.split(SPACE_DELIMITER);
        String[] reversedWords = new String[words.length];
        
        for (int i = 0; i < words.length; i++) {
            reversedWords[i] = reversedWord(words[i]);
        }
        return concat(reversedWords);
    }
    
    private void validateSentence(String sentence) {
        if (sentence == null) {
            throw new IllegalArgumentException("sentence is null");
        }
        if (sentence.trim().isEmpty()) {
            throw new IllegalArgumentException("sentence is empty or blank");
        }
    }
    
    private String reversedWord(String word) {
        
        char[] symbols = word.toCharArray();
        
        int firstIndex = 0;
        int lastIndex = symbols.length - 1;
        
        while (firstIndex < lastIndex) {
            if (Character.isLetter(symbols[firstIndex]) && Character.isLetter(symbols[lastIndex])) {
                swap(firstIndex, lastIndex, symbols);
                firstIndex++;
                lastIndex--;
            } else if (!Character.isLetter(symbols[firstIndex])) {
                firstIndex++;
            } else {
                lastIndex--;
            }
        }
        return String.valueOf(symbols);
    }
    
    private void swap(int firstIndex, int lastIndex, char[] symbols) {
        
        char temp = symbols[firstIndex];
        symbols[firstIndex] = symbols[lastIndex];
        symbols[lastIndex] = temp;
    }
    
    private String concat(String[] words) {
        return String.join(SPACE_DELIMITER, words);
    }
}
