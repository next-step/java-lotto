package lotto;

import lotto.domain.UserLottoTickets;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class WebApp {

    public static void main(String[] args) {

        port(8080);

        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return render(null, "/index.html");
        });

        post("/buyLotto", (req, res) -> {
            Map<String, Object> model = new HashMap<>();

            Money money = WebService.createMoney(req, WebService.manualLottoCount(req));
            UserLottoTickets userLottoTickets = WebService.createUserLottoTickets(money, req);

            req.session().attribute("userLottoTickets", userLottoTickets);
            req.session().attribute("money", money);


            model.put("userLottoTickets", userLottoTickets.getUserLottoTickets());
            model.put("totalTicketCount", money.getTotalTicketCount());
            return render(model, "/show.html");
        });

        post("/matchLotto", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            LotteryResults lotteryResults = WebService.createLotteryResult(request);
            Money money = request.session().attribute("money");

            model.put("firstCount", lotteryResults.getLottoResults().get(LottoRank.FIRST));
            model.put("secondCount", lotteryResults.getLottoResults().get(LottoRank.SECOND));
            model.put("thirdCount", lotteryResults.getLottoResults().get(LottoRank.THIRD));
            model.put("forthCount", lotteryResults.getLottoResults().get(LottoRank.FOURTH));
            model.put("fifthCount", lotteryResults.getLottoResults().get(LottoRank.FIFTH));
            model.put("profit", money.getProfit(lotteryResults));
            return render(model, "/result.html");
        });
    }

    public static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}
