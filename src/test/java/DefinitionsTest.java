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
  public void all_returnsAllInstancesOfDefinitions_true() {
    Definitions firstDefinition = new Definitions("favorite toy");
    Definitions secondDefinition = new Definitions("best toy");
    assertTrue(Definitions.all().contains(firstDefinition));
    assertTrue(Definitions.all().contains(secondDefinition));
  }

  @Test
  public void newId_DefinitionsInstantiateWithAnID_true() {
    Definitions myDefinition = new Definitions("favorite toy");
    assertEquals(Definitions.all().size(), myDefinition.getId());
  }

  @Test
  public void find_returnsDefinitionsWithSameId_secondDefinitions() {
    Definitions firstDefinition = new Definitions("favorite toy");
    Definitions secondDefinition = new Definitions("best toy");
    assertEquals(Definitions.find(secondDefinition.getId()), secondDefinition);
  }

  @Test
  public void find_returnsNullWhenNoDefinitionsFound_null() {
    assertTrue(Definitions.find(999) == null);
  }

  @Test
  public void clear_emptiesAllDefinitionssFromArrayList() {
    Definitions myDefinition = new Definitions("A tasty snack");
    Definitions.clear();
    assertEquals(Definitions.all().size(), 0);
  }



}
