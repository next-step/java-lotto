package lotto;

import spark.template.handlebars.HandlebarsTemplateEngine;

public class CustomHandlebarsTemplateEngine extends HandlebarsTemplateEngine {

    public CustomHandlebarsTemplateEngine() {
        super();
        handlebars.registerHelpers(this);
    }

    public String plusOne(int value) {
        return String.valueOf(value + 1);
    }
}