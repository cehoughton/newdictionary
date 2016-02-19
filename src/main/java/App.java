import java.util.HashMap;
import java.util.ArrayList;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
     String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
   }, new VelocityTemplateEngine());

    get("/words", (request,response) -> {
     HashMap<String, Object> model = new HashMap<String, Object>();
   //Word word = new Word(request.queryParams("inputWord"));
     model.put("words", Word.all());
     model.put("template", "templates/words.vtl");
     return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());

    post("/words", (request,response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      Word word = new Word(request.queryParams("inputWord"));
      model.put("words", Word.all());
      model.put("template", "templates/words.vtl");
      return new ModelAndView(model, layout);
   }, new VelocityTemplateEngine());

    get("/words/:id", (request, response) -> {
     HashMap<String, Object> model = new HashMap<String, Object>();
     Word word = Word.find(Integer.parseInt(request.params(":id")));
     model.put("word", word);
     model.put("template", "templates/word.vtl");
     return new ModelAndView(model, layout);
   }, new VelocityTemplateEngine());

     post("/definitions/:id", (request, response) -> {
       HashMap<String, Object> model = new HashMap<String, Object>();
       Word word = Word.find(Integer.parseInt(request.params(":id")));
       ArrayList<Definitions> definitions = word.getDefinitions();

       if (definitions == null) {
         definitions = new ArrayList<Definitions>();
       }

       String inputDef = request.queryParams("inputDef");
       Definitions newDef = new Definitions(inputDef);

       definitions.add(newDef);

       model.put("word", word);
       model.put("definitions", definitions);
       model.put("template", "templates/definitions.vtl");
       return new ModelAndView(model, layout);
   }, new VelocityTemplateEngine());



    }
}
