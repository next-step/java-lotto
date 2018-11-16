package net.chandol.lotto.view.console;

import net.chandol.lotto.view.web.LengthHelper;
import net.chandol.lotto.view.web.MathHelper;
import spark.template.handlebars.HandlebarsTemplateEngine;

public class CustomHandlebarsTemplateEngine extends HandlebarsTemplateEngine {

    public CustomHandlebarsTemplateEngine() {
        super();
        handlebars.registerHelper("math", new MathHelper());
        handlebars.registerHelper("length", new LengthHelper());
    }
}