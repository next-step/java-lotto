package lotto;

import lotto.domain.*;
import lotto.template.BasicHandlebarsTemplateEngine;
import spark.ModelAndView;
import spark.Session;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class WebMain {
    public static void main(String[] args) {
        port(8080);

        get("/", (req, res) -> render("index.html"));

        post("/buyLotto", (req, res) -> {
            LottoWallet lottoWallet = LottoWallet.create(req.queryParams("inputMoney"), req.queryParams("manualNumber"));
            LottoSet lottoSet = LottoShop.buy(lottoWallet);

            Session session = req.session();
            session.attribute("lottoWallet", lottoWallet);
            session.attribute("lottoSet", lottoSet);

            Map<String, Object> modelMap = new HashMap<>();
            modelMap.put("lottoSet", lottoSet);
            return render(modelMap,"show.html");
        });

        post("/matchLotto", (req, res) -> {
            Session session = req.session(false);
            LottoWallet lottoWallet = session.attribute("lottoWallet");
            LottoSet lottoSet = session.attribute("lottoSet");

            WinningLotto winningLotto = WinningLotto.create(req.queryParams("winningNumber"), req.queryParams("bonusNumber"));

            LottoMachine lottoMachine = new LottoMachine(lottoSet, winningLotto);
            LottoResultSet lottoResultSet = lottoMachine.createLottoResultSet();

            Map<String, Object> modelMap = new HashMap<>();
            modelMap.put("lottoResultSet", lottoResultSet);
            modelMap.put("rateReturn", lottoWallet.rateReturn(lottoResultSet.reward()).movePointRight(2));
            return render(modelMap, "result.html");
        });
    }

    private static String render(Map<String, Object> model, String templatePath) {
        return new BasicHandlebarsTemplateEngine()
                .render(new ModelAndView(model, templatePath));
    }

    private static String render(String templatePath) {
        return render(null, templatePath);
    }

}
