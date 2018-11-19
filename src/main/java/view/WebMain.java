package view;

import domain.*;
import spark.ModelAndView;
import spark.Session;
import util.CustomHandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

public class WebMain {
    public static void main(String[] args) {
        port(8080);

        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return render(model, "index.html");
        });

        post("/buyLotto", (req, res) -> {
            Map<String, Object> model = new HashMap<>();

            int money = Integer.parseInt(req.queryParams("inputMoney"));
            String[] manualNumbers = req.queryParams("manualNumber").split("\n");
            LottoCountManager lottoCountManager = new LottoCountManager(money, manualNumbers.length);

            List<Lotto> manualLottos = new ArrayList<>();
            for (String values : manualNumbers) {
                manualLottos.add(Lotto.manual(values));
            }

            LottoGame lottoGame = new LottoGame(lottoCountManager);
            lottoGame.buyManual(manualLottos);
            lottoGame.buyAuto();

            List<Lotto> lottos = lottoGame.getBoughtLottos();

            Session session = req.session();
            session.attribute("lottos", lottos);

            model.put("lottos", lottos);
            return render(model, "show.html");
        });

        post("/matchLotto", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            String winningNumber = req.queryParams("winningNumber");
            int bonusNumber = Integer.parseInt(req.queryParams("bonusNumber"));

            Session session = req.session();
            List<Lotto> lottos = session.attribute("lottos");

            WinningLotto winningLotto = new WinningLotto(winningNumber, bonusNumber);
            LottoStatistics lottoStatistics = new LottoStatistics(winningLotto);
            LottoReport lottoReport = lottoStatistics.report(lottos);

            model.put("report", lottoReport);
            return render(model, "result.html");
        });
    }

    public static String render(Map<String, Object> model, String templatePath) {
        return new CustomHandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}
