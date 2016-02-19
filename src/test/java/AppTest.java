import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.assertj.core.api.Assertions.*;
import static org.fluentlenium.core.filter.FilterConstructor.*;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();

  @Override
  public WebDriver getDefaultDriver() {
    return webDriver;
  }

    @ClassRule
    public static ServerRule server = new ServerRule();

    @Test
    public void rootTest() {
      goTo("http://localhost:4567/");
      assertThat(pageSource()).contains("Build your Dictionary!");
    }

    @Test
    public void wordIsCreatedTest() {
    goTo("http://localhost:4567");

    fill("#inputWord").with("Train");
    submit("btn");
    assertThat(pageSource()).contains("Train");
    }

    @Test
    public void defintionFormIsDisplayed() {
      Word word = new Word("Bike");
      goTo("http://localhost:4567/words/" + word.getId());
      assertThat(pageSource()).contains("Bike");
    }

    @Test
    public void defintionIsIsAddedToWord() {
      Word word = new Word("Bike");
      goTo("http://localhost:4567/words/" + word.getId());
      fill("#inputDef").with("best toy");
      submit(".btn");
      assertThat(pageSource()).contains("best toy");
    }
}
