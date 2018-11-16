import com.github.jknack.handlebars.Helper;
import spark.template.handlebars.HandlebarsTemplateEngine;

public class CustomHandlebarsTemplateEngine extends HandlebarsTemplateEngine {
    public CustomHandlebarsTemplateEngine() {
        super();

        handlebars.registerHelper("counter", (Helper<Integer>) (context, options) -> context + 1);
    }
}
