import java.util.ArrayList;

public class Word {
  private static ArrayList<Word> instances = new ArrayList<Word>();

  private String mWord;
  private int mId;
  // private ArrayList<Definitions> mDefinitions;

  public Word(String inputWord) {
    mWord = inputWord;
    instances.add(this);
    mId = instances.size();
    // mDefinitions = new ArrayList<Definitions>();
  }

  public String getWord() {
    return mWord;
  }

  public int getId() {
    return mId;
  }

  // public ArrayList<Defintions> getDefintions() {
  //   return mDefintions;
  // }
}
