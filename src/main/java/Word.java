import java.util.ArrayList;

public class Word {
  private static ArrayList<Word> instances = new ArrayList<Word>();

  private String mWord;
  private int mId;
  private ArrayList<Definitions> mDefinitions;

  public Word(String inputWord) {
    mWord = inputWord;
    instances.add(this);
    mId = instances.size();
    mDefinitions = new ArrayList<Definitions>();
  }

  public String getWord() {
    return mWord;
  }

  public int getId() {
    return mId;
  }

  public static ArrayList<Word> all() {
    return instances;
  }

  public static void clear() {
   instances.clear();
}

  public static Word find(int id) {
    try {
      return instances.get(id - 1);
    } catch (IndexOutOfBoundsException exception) {
      return null;
    }
  }

  public ArrayList<Definitions> getDefinitions() {
    return mDefinitions;
  }
}
