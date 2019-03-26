package lotto.web;

import lotto.domain.LottoBundle;
import lotto.enums.LottoRank;
import lotto.vo.LottoGameResult;
import spark.ModelAndView;
import spark.Request;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class LottoController {
    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void start(int port) {
        port(port);

        index();
        show();
        result();
    }

    public void index() {
        get("/", (request, response) -> render(null, "index.html"));
    }

    public void show() {
        post("/buyLotto", (request, response) -> {
            LottoBundle lottoBundle = lottoService.buyLotto(request);
            putAttribute(request, "lottoBundle", lottoBundle);

            Map<String, Object> model = new HashMap<>();
            model.put("lottos", lottoBundle.getLottos());

            return render(model, "show.html");
        });
    }

    public void result() {
        post("/matchLotto", (request, response) -> {
            LottoBundle lottoBundle = (LottoBundle) getAttribute(request, "lottoBundle");
            LottoGameResult lottoGameResult = lottoService.matchLotto(request, lottoBundle);

            Map<String, Object> model = new HashMap<>();
            model.put("result", lottoGameResult.getLottoWinResult());
            model.put("profitRate", lottoGameResult.getTotalProfitRate());
            model.put("lottoRanks", LottoRank.values());

            return render(model, "result.html");
        });
    }

    private String render(Map<String, Object> model, String templatePath) {
        ModelAndView modelAndView = new ModelAndView(model, templatePath);
        return new HandlebarsTemplateEngine().render(modelAndView);
    }

    private void putAttribute(Request request, String key, Object value) {
        request.session().attribute(key, value);
    }

    private Object getAttribute(Request request, String key) {
        return request.session().attribute(key);
    }
}
