package ua.com.foxminded.anagrams;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class AnagramCreaterTest {
    
    private final AnagramCreater anagramCreater = new AnagramCreater();

    @Test
    void makeAnagramShouldReturnAnagramFor2WordsJustWithLetters() {
        String expected = "olleH dlroW";
        String actual = anagramCreater.createAnagram("Hello World");
        
        assertEquals(expected, actual);
    }
    
    @Test
    void makeAnagramShouldReturnAnagramFor1WordJustWithLetters() {
        String expected = "olleh";
        String actual = anagramCreater.createAnagram("hello");
        assertEquals(expected, actual);
    }
    
    @Test
    void makeAnagramShouldReturnAnagramFor1WordJustWithNotLetters() {
        String expected = "112358!!%%";
        String actual = anagramCreater.createAnagram("112358!!%%");
        
        assertEquals(expected, actual);
    }
    
    @Test
    void makeAnagramShouldReturnAnagramFor1WordWithLettersAndNotLetters() {
        String expected = "dlr123oW!!";
        String actual = anagramCreater.createAnagram("Wor123ld!!");
        
        assertEquals(expected, actual);
    }
    
    @Test
    void makeAnagramShouldReturnAnagramFor2WordJustWithNotLetters() {
        String expected = "123 123!@";
        String actual = anagramCreater.createAnagram("123 123!@");
        
        assertEquals(expected, actual);
    }
    
    @Test
    void makeAnagramShouldReturnAnagramFor2WordWithLettersAndNotLetters() {
        String expected = "ol23leH7 dl63roW!!";
        String actual = anagramCreater.createAnagram("He23llo7 Wo63rld!!");
        
        assertEquals(expected, actual);
    }
    
    @Test
    void makeAnagramShouldReturnAnagramFor3WordWithLettersAndNotLetters() {
        String expected = "ol23leH7 dl63roW!! kp77ptkj63";
        String actual = anagramCreater.createAnagram("He23llo7 Wo63rld!! jk77tppk63");
        
        assertEquals(expected, actual);
    }
    
    @Test
    void makeAnagramShouldReturnAnagramForNull() {
        IllegalArgumentException exeption = assertThrows(IllegalArgumentException.class, () -> 
            anagramCreater.createAnagram(null)
        ); 
        
        String expected = "sentence is null";
        String actual = exeption.getMessage();
        
        assertEquals(expected, actual);
    }  
    
    @Test
    void makeAnagramShouldReturnAnagramForEmpty() {
        IllegalArgumentException exeption = assertThrows(IllegalArgumentException.class, () -> 
            anagramCreater.createAnagram("")
        ); 
        
        String expected = "sentence is empty or blank";
        String actual = exeption.getMessage();
        
        assertEquals(expected, actual);
    } 
    
    @Test
    void makeAnagramShouldReturnAnagramForSpaces() {
        IllegalArgumentException exeption = assertThrows(IllegalArgumentException.class, () -> 
            anagramCreater.createAnagram("          ")
        ); 
        
        String expected = "sentence is empty or blank";
        String actual = exeption.getMessage();
        
        assertEquals(expected, actual);
    } 
}
