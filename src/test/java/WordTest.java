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

  @Test
  public void clear_removesAllWordInstancesFromMemory() {
   Word testWord = new Word("Cat");
   Word.clear();
   assertEquals(Word.all().size(), 0);
   }

  @Test
  public void find_returnsWordWithSameId() {
   Word testWord = new Word("Train");
   assertEquals(Word.find(testWord.getId()), testWord);
  }

  @Test
  public void getDefinitions_initiallyReturnsempptyArrayList() {
   Word testWord = new Word("Train");
   assertTrue(testWord.getDefinitions() instanceof ArrayList);
  }

  @Test
   public void addDefinition_addsDefinitionToList() {
    Word testWord = new Word("Train");
    Definitions testDef = new Definitions("favorite toy");
    testWord.addDefinition(testDef);
    assertTrue(testWord.getDefinitions().contains(testDef));
  }




}
