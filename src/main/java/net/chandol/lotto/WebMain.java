package net.chandol.lotto;

import net.chandol.lotto.domain.LottoGame;
import net.chandol.lotto.domain.LottoGameResult;
import net.chandol.lotto.dto.PurchaseRequest;
import net.chandol.lotto.type.LottoPrize;
import net.chandol.lotto.value.LottoNumber;
import net.chandol.lotto.value.Money;
import net.chandol.lotto.value.WinningNumber;
import net.chandol.lotto.view.ViewUtil;
import net.chandol.lotto.view.console.CustomHandlebarsTemplateEngine;
import spark.ModelAndView;
import spark.Request;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.lang.String.valueOf;
import static spark.Spark.*;

public class WebMain {
    public static void main(String[] args) {
        port(8080);

        get("/", (req, res) -> render("index.html"));

        post("/buyLotto", (req, res) -> {
            PurchaseRequest purchaseRequest = getPurchaseRequest(req);
            LottoGame lottoGame = new LottoGame(purchaseRequest);
            req.session().attribute("lottoGame", lottoGame);

            return render(getBuyingLottoResultMap(lottoGame), "show.html");
        });


        post("/matchLotto", (req, res) -> {
            LottoGame lottoGame = req.session(false).attribute("lottoGame");

            WinningNumber winningNumber = getWinningNumber(req);
            LottoGameResult lottoGameResult = lottoGame.getLottoGameResult(winningNumber);

            return render(createResultModelMap(lottoGameResult), "result.html");
        });
    }

    private static Map<String, Object> getBuyingLottoResultMap(LottoGame lottoGame) {
        List<String> formattedLottos = lottoGame.getLottos().stream()
                .map(ViewUtil::formatLotto)
                .collect(Collectors.toList());

        return new HashMap<String, Object>() {{
            put("lottos", formattedLottos);
        }};
    }

    private static Map<String, Object> createResultModelMap(LottoGameResult result) {
        return new HashMap<String, Object>(){{
            put("gameResult1st", result.getFormattedResult(LottoPrize._1));
            put("gameResult2nd", result.getFormattedResult(LottoPrize._2));
            put("gameResult3rd", result.getFormattedResult(LottoPrize._3));
            put("gameResult4th", result.getFormattedResult(LottoPrize._4));
            put("gameResult5th", result.getFormattedResult(LottoPrize._5));

            put("profitRate", valueOf(result.getProfitRate() * 100));
        }};
    }

    private static WinningNumber getWinningNumber(Request req) {
        String rawWinningNumber = req.queryParams("winningNumber");
        Integer rawBonusNumber = Integer.valueOf(req.queryParams("bonusNumber"));

        LottoNumber winningNumber = ViewUtil.getLottoNumber(rawWinningNumber);
        return new WinningNumber(winningNumber, rawBonusNumber);
    }

    private static PurchaseRequest getPurchaseRequest(Request req) {
        String inputMoney = req.queryParams("inputMoney");
        String manualNumber = req.queryParams("manualNumber");
        List<String> strings = Arrays.asList(manualNumber.split("\n"));
        List<LottoNumber> lottoNumbers = ViewUtil.getLottoNumbers(strings);

        return new PurchaseRequest(Money.of(Integer.valueOf(inputMoney)), lottoNumbers);
    }


    private static String render(Map<String, Object> model, String templatePath) {
        return new CustomHandlebarsTemplateEngine()
                .render(new ModelAndView(model, templatePath));
    }

    private static String render(String templatePath) {
        return render(null, templatePath);
    }

}
