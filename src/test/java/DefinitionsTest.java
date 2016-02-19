import org.junit.*;
import static org.junit.Assert.*;

public class DefinitionsTest {

  @Rule
  public ClearRule clearRule = new ClearRule();

  @Test
  public void defintions_instantiatesCorrectly_true() {
      Definitions myDefinition = new Definitions("favorite toy");
      assertEquals(true, myDefinition instanceof Definitions);
  }

}
