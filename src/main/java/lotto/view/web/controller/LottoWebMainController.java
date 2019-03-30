package lotto.view.web.controller;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;

public class LottoWebMainController implements LottoWebController {

    public LottoWebMainController() {
        mainPage();
        new LottoBuyController();
        new LottoMatchController();
    }

    public void mainPage() {
        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return render(model, "/index.html");
        });
    }

    @Override
    public String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}
