package lotto.controller;

import lotto.domain.Lottos;
import lotto.domain.LottosResult;
import lotto.service.Service;
import spark.ModelAndView;
import spark.Request;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;

public class Controller {
    private Service service;

    public Controller(final Service service) {
        this.service = service;
        get("/", (req, res) -> serveIndexPage());

        post("/buyLotto", (req, res) -> serveShowPage(req));

        post("/matchLotto", (req, res) -> serveResultPage(req));
    }

    public String serveIndexPage() {
        return render(null, "index.html");
    }

    public String serveShowPage(Request request) {
        Lottos lottos = service.buyLotto(request);
        setAttribute(request, "lottos", lottos);

        Map<String, Object> model = new HashMap<>();
        model.put("lottos", lottos);
        return render(model, "show.html");
    }

    public String serveResultPage(Request request) {
        Lottos lottos = (Lottos) getAttribute(request, "lottos");
        LottosResult lottosResult = service.matchLotto(request, lottos);

        Map<String, Object> model = new HashMap<>();
        model.put("lottosResult", lottosResult);
        return render(model, "result.html");
    }

    private String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }

    private void setAttribute(Request request, String key, Object value) {
        request.session().attribute(key, value);
    }

    private Object getAttribute(Request request, String key) {
        return request.session().attribute(key);
    }
}
