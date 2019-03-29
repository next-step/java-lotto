package lotto;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import lotto.domain.Lotto;
import lotto.domain.LottoList;
import lotto.domain.LottoMatcher;
import lotto.domain.LottoMoney;
import lotto.domain.LottoNumber;
import lotto.domain.MatchResults;
import lotto.domain.Rank;
import lotto.domain.RankCount;
import lotto.domain.WinningLotto;
import lotto.web.BuyLottoResponse;
import lotto.web.MatchLottoResponse;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

public class LottoWebApp {

    public static void main(String[] args) {
        port(8080);

        get("/", (req, res) -> render(null, "/index.html"));

        post("/buyLotto", (req, res) -> {
            final long inputMoney = Long.parseLong(req.queryParams("inputMoney"));
            final LottoMoney lottoMoney = new LottoMoney(inputMoney);

            LottoList manualLottos = new LottoList();

            Arrays.stream(req.queryParams("manualNumber").split("\r\n"))
                .forEach(manualNumber -> manualLottos.add(new Lotto(manualNumber.split(","))));

            final LottoList lottos = new LottoList(lottoMoney.countOfLotto(), manualLottos);

            req.session().attribute("lottoMoney", new LottoMoney(inputMoney));
            req.session().attribute("lottos", lottos);

            BuyLottoResponse buyLottoResponse = new BuyLottoResponse.Builder()
                .inputMoney(inputMoney)
                .lottos(lottos.getLottos())
                .manualCount(lottos.sizeOfManuals())
                .build();

            return render(buyLottoResponse, "/show.html");
        });

        post("/matchLotto", (req, res) -> {
            final Lotto winningNumber = new Lotto(req.queryParams("winningNumber").split(","));
            final LottoNumber bonusNumber = LottoNumber.valueOf(req.queryParams("bonusNumber"));

            final LottoMoney lottoMoney = req.session().attribute("lottoMoney");
            final LottoList lottos = req.session().attribute("lottos");

            final MatchResults matchResults = LottoMatcher.calculateMatchResults(lottos, new WinningLotto(winningNumber, bonusNumber));
            List<RankCount> lottoResult = new ArrayList<>();

            Set<Rank> reversedKeyRanks = new TreeSet<>(Collections.reverseOrder());
            reversedKeyRanks.addAll(matchResults.keySet());

            for (Rank rank : reversedKeyRanks) {
                if (!rank.isInTop5()) {
                    continue;
                }

                lottoResult.add(matchResults.get(rank));
            }

            MatchLottoResponse matchLottoResponse = new MatchLottoResponse.Builder()
                .lottoResult(lottoResult)
                .earningsRate(lottoMoney.calculateEarningsRate(matchResults))
                .build();

            return render(matchLottoResponse, "/result.html");
        });
    }

    public static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }

    public static String render(Object model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}
