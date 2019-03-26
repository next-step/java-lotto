package lottogame.controller;

import lottogame.util.StringUtils;
import lottogame.validator.InputLineValidator;
import lottogame.validator.Validatable;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.Map;

public abstract class AbstractController {

    private static final Validatable<String> validator = new InputLineValidator();
    protected static final String INDEX_TEMPLATE_PATH = "index.html";

    protected static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }

    protected static void redirectToIndex(Response response) {
        response.redirect(INDEX_TEMPLATE_PATH);
    }

    protected static String getInputLine(Request req, String key) {
        String inputLine = req.queryParams(key);
        validator.validate(inputLine);
        return StringUtils.removeWhitespace(inputLine);
    }

}
