package lotto.view.web.controller;

import lotto.domain.*;
import lotto.view.util.LottoViewParameterHandler;
import spark.ModelAndView;
import spark.Session;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.post;

public class LottoMatchController implements LottoWebController {

    public LottoMatchController() {
        matchLottoResult();
    }

    private void matchLottoResult() {
        post("/matchLotto", (request, response) -> {
            String[] winningNumbers = LottoViewParameterHandler.toStringArray(request.queryParams("winningNumber"));
            String bonusNumber = request.queryParams("bonusNumber");

            Session session = request.session();
            LottoMoney lottoMoney = session.attribute("lottoMoney");
            LottoBundle lottoBundle = session.attribute("lottoBundle");

            Map<String, Object> model = new HashMap<>();
            LottoMatcher lottoMatcher = new LottoMatcher(lottoBundle, new WinningLotto(winningNumbers, bonusNumber));
            EarningRate earningRate = new EarningRate(lottoMatcher, lottoMoney);
            model.put("lottoMatcher", LottoViewParameterHandler.toStringList(lottoMatcher));
            model.put("earningRate", earningRate.toString());

            return render(model, "/result.html");
        });
    }

    @Override
    public String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}
