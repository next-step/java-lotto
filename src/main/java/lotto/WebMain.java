package lotto;

import lotto.domain.*;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

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

            return render(model, "/index.html");
        });

        post("/buyLotto", (req, res) -> {
            Map<String, Object> model = new HashMap<>();

            String strMoney = req.queryParams("inputMoney");
            Money money = new Money(Integer.parseInt(strMoney));
            req.session().attribute("money", money);
            int totalCount = money.getTotalCount();

            String manualNumbers = req.queryParams("manualNumber");
            String[] manualLotto = manualNumbers.split("\r\n");

            Lotteries lotteries = new Lotteries(totalCount);
            List<Lotto> boughtLotteries = lotteries.buyLotto(manualLotto);
            req.session().attribute("totalLotteries", boughtLotteries);
            List<String> printLotteries = new ArrayList<>();

            for (Lotto oneLotto : boughtLotteries) {
                printLotteries.add(oneLotto.toString(","));
            }
            model.put("autoCount", totalCount - manualLotto.length);
            model.put("manualCount", manualLotto.length);
            model.put("lottoNumbers", printLotteries);

            return render(model, "/show.html");
        });

        post("/matchLotto", (req, res) -> {
            Map<String, Object> model = new HashMap<>();

            String winningNumber = req.queryParams("winningNumber");
            String bonusNumber = req.queryParams("bonusNumber");
            List<Lotto> boughtLotteries = req.session().attribute("totalLotteries");
            WinningLotto winningLotto = new WinningLotto(winningNumber, Integer.parseInt(bonusNumber));
            LottoCompare compare = new LottoCompare();

            LottoResult result = compare.match(boughtLotteries, winningLotto);
            Money money = req.session().attribute("money");

            model.put("fifth", result.get(Rank.FIFTH));
            model.put("fourth", result.get(Rank.FOURTH));
            model.put("third", result.get(Rank.THIRD));
            model.put("second", result.get(Rank.SECOND));
            model.put("first", result.get(Rank.FIRST));
            model.put("winRate", money.calculateRate(result.getTotalSum()));

            return render(model, "result.html");

        });
    }

    public static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}
