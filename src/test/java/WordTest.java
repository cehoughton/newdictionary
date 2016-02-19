import java.util.ArrayList;

import org.junit.*;
import static org.junit.Assert.*;

public class WordTest {

@Test
 public void getWord_returnsWord_Dog() {
  Word testWord = new Word("Dog");
  assertEquals("Dog", testWord.getWord());
  }

@Test
 public void getId_returnsWordId() {
   Word testWord = new Word("Dog");
   assertTrue(Word.all().size() == testWord.getId());
 }

 @Test
 public void all_returnsAllInstancesOfWord_true() {
  Word firstWord = new Word("Cat");
  Word secondWord = new Word("Dog");
  assertTrue(Word.all().contains(firstWord));
  assertTrue(Word.all().contains(secondWord));
  }
}
