import domain.*;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static domain.Money.calculateAmount;
import static domain.Rank.*;
import static domain.Rank.FIRST;
import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;
import static util.ConsoleUtil.changeWinNumberToInteger;
import static util.Validation.validatePurchaseAmount;
import static util.Validation.validatePurchaseMoney;
import static view.InputView.*;


public class WebMain {

    static LottoGame lottoGame;
    static List<Lotto> lottos;
    static Money totalPurchaseMoney;


    public static void main(String[] args) {
        port(8080);

        get("/", (req, res) -> render(null, "index.html"));

        post("/buyLotto", (req, res) -> {
            totalPurchaseMoney = Money.from(Integer.valueOf(req.queryParams("inputMoney")));
            validatePurchaseMoney(totalPurchaseMoney);

            String [] manual = req.queryParams("manualNumber").split("\r\n");
            LottoAmount manualPurchaseAmount = LottoAmount.from(manual.length);
            validatePurchaseAmount(manualPurchaseAmount);

            lottoGame = LottoGame.from(calculateAmount(totalPurchaseMoney), manualPurchaseAmount, new RandomNumberGenerator());

            List<List<LottoNo>> manualPurchaseNumbers = new ArrayList();
            for (int i = 0; i < manual.length; i++) {
                manualPurchaseNumbers.add(changeWinNumberToInteger(manual[i]));
            }
            lottoGame.generateByManual(manualPurchaseNumbers);

            Map<String, Object> model = new HashMap<>();
            model.put("manualPurchaseAmount", manualPurchaseAmount.getAmount());
            model.put("autoPurchaseAmount", lottoGame.calculateAutoPurchaseAmount().getAmount());

            lottos = lottoGame.getLottoNumbers();
            model.put("lottos", lottos);

            return render(model, "show.html");
        });
//
        post("/matchLotto", (req, res) -> {
            List<LottoNo> winningNumber = changeWinNumberToInteger(req.queryParams("winningNumber"));
            LottoNo bonusNumber = LottoNo.from(Integer.parseInt(req.queryParams("bonusNumber")));
            System.out.println("lottoGame.getLottoNumbers()");
            System.out.println(lottoGame.getLottoNumbers());
            lottoGame.calculateAllRank(LottoWinning.from(winningNumber, bonusNumber));

            RankAmount rankLongMap = RankAmount.from(lottoGame.getLottoNumbers());

            Map<String, Object> model = new HashMap<>();
            model.put("fifth", rankLongMap.getRankAmount().get(Rank.FIFTH));
            model.put("fourth", rankLongMap.getRankAmount().get(Rank.FOURTH));
            model.put("third", rankLongMap.getRankAmount().get(Rank.THIRD));
            model.put("second", rankLongMap.getRankAmount().get(Rank.SECOND));
            model.put("first", rankLongMap.getRankAmount().get(Rank.FIRST));

            float yield = rankLongMap.calculateYield(totalPurchaseMoney);
            model.put("yield", yield);

            return render(model, "result.html");
        });
    }
    public static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}
