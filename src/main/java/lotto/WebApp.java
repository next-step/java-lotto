package lotto;

import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import lotto.domain.UserLottoTickets;
import lotto.domain.WiningLottoTicket;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;
import static spark.Spark.post;

public class WebApp {
    private static LottoMachine lottoMachine = new LottoMachine(new UserLottoTicketGenerator());
    private static UserLottoTickets userLottoTickets;
    private static Money money;
    public static void main(String[] args) {

        port(8080);

        get("/", (req, res) -> {
            Map<String,Object> model = new HashMap<>();
            return render(null, "/index.html");
        });

        post("/buyLotto", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int amout =  Integer.parseInt(req.queryParams("inputMoney"));
            String manualNumber = req.queryParams("manualNumber");
            String[] manualNumbers = manualNumber.split("\n");
            money = new Money(amout, manualNumbers.length);
            userLottoTickets = lottoMachine.buyLottoTicket(money, StringParseUtils.parseToLottoTickets(manualNumbers));
            model.put("userLottoTickets", userLottoTickets.getUserLottoTickets());
            model.put("totalTicketCount", money.getTotalTicketCount());
            return render(model, "/show.html");
        });

        post("/matchLotto", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            LottoTicket winningNumber = StringParseUtils.parseToLottoTicket(request.queryParams("winningNumber"));
            LottoNumber bonusNumber = LottoNumber.getBasicNumber(Integer.parseInt(request.queryParams("bonusNumber")));
            WiningLottoTicket winingLottoTicket = new WiningLottoTicket(winningNumber, bonusNumber);
            LotteryResults lotteryResults = new LotteryResults(winingLottoTicket, userLottoTickets);
            double profit = money.getProfit(lotteryResults);
            model.put("firstCount", lotteryResults.getLottoResults().get(LottoRank.FIRST));
            model.put("secondCount", lotteryResults.getLottoResults().get(LottoRank.SECOND));
            model.put("thirdCount", lotteryResults.getLottoResults().get(LottoRank.THIRD));
            model.put("forthCount", lotteryResults.getLottoResults().get(LottoRank.FOURTH));
            model.put("fifthCount", lotteryResults.getLottoResults().get(LottoRank.FIFTH));
            model.put("profit", profit);
            return render(model, "/result.html");
        });

    }

    public static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }

}
