package lotto.view.web.controller;

import lotto.domain.LottoBundle;
import lotto.domain.LottoMoney;
import lotto.tool.LottoMachine;
import lotto.view.util.LottoViewParameterHandler;
import spark.ModelAndView;
import spark.Session;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.post;

public class LottoBuyController implements LottoWebController {

    public LottoBuyController() {
        buyLottoTickets();
    }

    private void buyLottoTickets() {
        post("/buyLotto", (request, response) -> {
            LottoMoney lottoMoney = new LottoMoney(Integer.parseInt(request.queryParams("inputMoney")));
            List<String[]> manualLottoNumbers = LottoViewParameterHandler.toStringArrayList(request.queryParams("manualNumber"));
            LottoBundle lottoBundle = LottoMachine.issueTickets(lottoMoney, manualLottoNumbers);

            Session session = request.session();
            session.attribute("lottoBundle", lottoBundle);
            session.attribute("lottoMoney", lottoMoney);

            Map<String, Object> model = new HashMap<>();
            model.put("ticketCount", lottoMoney.buy());
            model.put("lottoTickets", LottoViewParameterHandler.toStringList(lottoBundle));

            return render(model, "/show.html");
        });
    }

    @Override
    public String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}
