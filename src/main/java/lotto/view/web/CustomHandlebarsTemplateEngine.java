package lotto.view.web;

import com.github.jknack.handlebars.Helper;
import spark.template.handlebars.HandlebarsTemplateEngine;

public class CustomHandlebarsTemplateEngine extends HandlebarsTemplateEngine {

	public CustomHandlebarsTemplateEngine() {
		super();
		handlebars.registerHelper("counter", (Helper<Integer>) (index, options) -> index + 1);
		handlebars.registerHelper("result", new ResultHelper());
	}
}
