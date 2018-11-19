package lotto.ui.handlebars;

import lotto.ui.handlebars.helper.CollectionLengthHelper;
import lotto.ui.handlebars.helper.IncrementsHelper;
import lotto.ui.handlebars.helper.MapGetHelper;
import spark.template.handlebars.HandlebarsTemplateEngine;

public class CustomHandlebarsTemplateEngine extends HandlebarsTemplateEngine {

    public CustomHandlebarsTemplateEngine() {
        super();
        this.handlebars.registerHelper("length", new CollectionLengthHelper());
        this.handlebars.registerHelper("inc", new IncrementsHelper());
        this.handlebars.registerHelper("mapget", new MapGetHelper());
    }

}
