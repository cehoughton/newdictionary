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

  @Test
  public void definitions_instantiatesWithDescription_true() {
      Definitions myDefinition = new Definitions("favorite toy");
      assertEquals("favorite toy", myDefinition.getInputDef());
  }

  @Test
  public void all_returnsAllInstancesOfDefinition_true() {
    Definitions firstDefinition = new Definitions("favorite toy");
    Definitions secondDefinition = new Definitions("best toy");
    assertTrue(Definitions.all().contains(firstDefinition));
    assertTrue(Definitions.all().contains(secondDefinition));


  }



}
