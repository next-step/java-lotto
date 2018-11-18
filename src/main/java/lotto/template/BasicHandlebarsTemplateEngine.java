package lotto.template;

import com.github.jknack.handlebars.Helper;
import com.github.jknack.handlebars.Options;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.io.IOException;
import java.util.Objects;

public class BasicHandlebarsTemplateEngine extends HandlebarsTemplateEngine {
    public BasicHandlebarsTemplateEngine() {
        super();
        this.handlebars.registerHelper("repeat", this::repeat);
        this.handlebars.registerHelper("no", (Helper<Integer>) (context, options) -> context + 1);
    }

    private Object repeat(Integer context, Options options) throws IOException {
        if(Objects.isNull(context)){
            return "";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < context; i++) {
            sb.append(options.fn(i + 1));
        }
        return sb.toString();
    }
}
