package util;

import spark.template.handlebars.HandlebarsTemplateEngine;

public class CustomHandlebarsTemplateEngine extends HandlebarsTemplateEngine {
    public CustomHandlebarsTemplateEngine() {
        super();
        this.handlebars.registerHelper(LottoSizeHelper.NAME, new LottoSizeHelper());
        this.handlebars.registerHelper(LottoPositionHelper.NAME, new LottoPositionHelper());
    }
}
