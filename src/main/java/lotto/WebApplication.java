package lotto;


import lotto.enums.LottoReword;
import lotto.model.Lotto;
import lotto.model.LottoGame;
import lotto.model.LottoGameResult;
import lotto.model.LottoNo;
import lotto.model.Money;
import lotto.ui.handlebars.CustomHandlebarsTemplateEngine;
import spark.ModelAndView;
import spark.Session;

import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.exception;
import static spark.Spark.port;
import static spark.Spark.get;
import static spark.Spark.post;

public class WebApplication {
    public static void main(String[] args) {
        port(8080);

        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();

            return render(model, "/index.html");
        });

        post("/buyLotto", (request, response) -> {
            Map<String, Object> model = new HashMap<>();

            String totalPrice = request.queryParams("inputMoney");
            String manualNumbers = request.queryParams("manualNumber");

            Money money = new Money(Integer.parseInt(totalPrice));
            LottoGame lottoGame = new LottoGame();
            List<Lotto> lottos = lottoGame.createLotto(money, manualNumbers);

            request.session().attribute("money", money);
            request.session().attribute("lottoGame", lottoGame);

            model.put("lottos", lottos);

            return render(model, "/show.html");
        });

        post("/matchLotto", (request, response) -> {
            Map<String, Object> model = new HashMap<>();

            String winnerNumber = request.queryParams("winningNumber");
            String bonusNumber = request.queryParams("bonusNumber");

            LottoGame lottoGame = request.session().attribute("lottoGame");
            Money money = request.session().attribute("money");

            LottoGameResult rewordLotto = lottoGame.getReword(winnerNumber, Integer.parseInt(bonusNumber));
            float earningsRate = rewordLotto.earningsRate(money);

            model.put("result", rewordLotto.getResults());
            model.put("earningsRate", earningsRate);
            model.put("lottoReword", LottoReword.values());

            return render(model, "/result.html");
        });

        exception(InvalidParameterException.class, (e, request, response) -> {
            response.status(401);
            response.body(e.getMessage());
        });

        exception(Exception.class, (e, request, response) -> {
            response.status(500);
            response.body(e.getMessage());
            e.printStackTrace();
        });
    }

    public static String render(Map<String, Object> model, String templatePath) {
        return new CustomHandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}
