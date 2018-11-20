package lotto.view.web;

import lotto.domain.*;
import lotto.domain.generator.ManualLottoGenerator;
import lotto.view.ResultView;
import lotto.view.util.LottoParse;
import spark.ModelAndView;
import spark.Session;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class WebMain {

    public static void main(String[] args){
        port(8080);
        staticFiles.location("/templates");

        get("/", (req, res) -> {
            return "index.html";
        });

        post("/buyLotto", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            Money money = new Money(Integer.parseInt(req.queryParams("inputMoney")));
            String[] manualNumbers = LottoParse.stringToLottoStringNumber(req.queryParams("manualNumber"));
            LottoGenerator lottoGenerator = new ManualLottoGenerator(manualNumbers);

            List<Lotto> lottos =  lottoGenerator.generate(money);
            int lottoCount = money.calcLottoCount();

            Session session = req.session();
            session.attribute("lottos", lottos);
            session.attribute("money", money);

            model.put("lottos", lottos);
            model.put("lottoCount", lottoCount);
            return render(model, "show.html");
        });

        post("/matchLotto", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            Session session = req.session();
            String inputWinningLotto = req.queryParams("winningNumber");
            String inputWinningBonus = req.queryParams("bonusNumber");

            List<Lotto> lottos = session.attribute("lottos");
            Money money = session.attribute("money");

            WinningLotto winningLotto = new WinningLotto(Lotto.fromComma(inputWinningLotto), LottoNo.of(Integer.parseInt(inputWinningBonus)));

            LottoResultDefault result = new LottoResultDefault();
            for(Lotto lotto : lottos) {
                result.setRankingStatus(winningLotto.getRankByMatchingLotto(lotto));
            }

            double profitRate = money.profitRate(result.getTotalPrize());

            model.put("result", result);
            model.put("profitRate", profitRate);
            return render(model, "result.html");
        });
    }

    public static String render(Map<String, Object> model, String templatePath) {
        return new CustomHandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}
