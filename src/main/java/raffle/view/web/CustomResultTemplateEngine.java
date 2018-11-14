package raffle.view.web;

import spark.template.handlebars.HandlebarsTemplateEngine;

public class CustomResultTemplateEngine extends HandlebarsTemplateEngine {
    public CustomResultTemplateEngine() {
        super();
        handlebars.registerHelper("result", new ResultHelper());
    }
}
