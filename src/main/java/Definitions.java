import java.util.ArrayList;
 
public class Definitions {
  private String mInputDef;
  private static ArrayList<Definitions> instances =new ArrayList<Definitions>();
  private int mId;


  public Definitions(String inputDef) {
  mInputDef = inputDef;
  instances.add(this);
  mId = instances.size();
  }

  public String getInputDef() {
    return mInputDef;
  }

  public static ArrayList<Definitions> all() {
      return instances;
  }

  public static Definitions find(int id) {
      try {
          return instances.get(id - 1);
      } catch (IndexOutOfBoundsException iobe) {
          return null;
      }
  }
  public static void clear() {
        instances.clear();
  }

   public int getId() {
    return mId;
  }
}
