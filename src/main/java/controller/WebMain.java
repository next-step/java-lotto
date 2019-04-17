package controller;

import static spark.Spark.*;

import domain.*;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import view.InputView;

import java.util.*;

public class WebMain {
    private static LottoGame lottoGame;
    private static LottoMoney money;

    public static void main (String[] args) {
        port(8080);
        get("/start", (req, res) -> render(null, "index.html"));

        post("/buyLotto", (req, res) -> {
            Map<String, Object> model = new HashMap<>();

            String inputMoney = req.queryParams("inputMoney");
            String[] inputForManualLotto = req.queryParams("manualNumber").split("\n");

            money = WebService.getLottoMoney(inputMoney);

            lottoGame = new LottoGame(money,
                                    WebService.getUserLottos(inputForManualLotto));

            model.put("totalCount", lottoGame.getNumberOfUserLottos());
            model.put("lottos", lottoGame.getUserLottos());

            return render(model, "show.html");
        });

        post("/matchLotto", (req, res) -> {
            Map<String, Object> model = new HashMap<>();

            String winningLottoInput = req.queryParams("winningNumber");
            int bonusInput = toInt(req.queryParams("bonusNumber"));

            WinningLotto winningLotto = new WinningLotto(InputView.splitStringToLotto(winningLottoInput), bonusInput);

            LottoGameResult result = lottoGame.getMultipleResults(winningLotto);
            List<String> results = WebService.getResults(result);

            model.put("results", results);
            model.put("profitRate", result.getProfitRate(money));

            return render(model, "result.html");
        });

    }

    private static int toInt(String input) {
        return Integer.parseInt(input);
    }

    private static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}
