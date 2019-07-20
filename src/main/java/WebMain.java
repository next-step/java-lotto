import domain.*;
import spark.ModelAndView;
import spark.Route;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.*;
import java.util.stream.Collectors;

import static spark.Spark.*;

public class WebMain {

    private static LottoPaper lottoPaper;

    public static void main(String[] args) {
        port(8080);

        get("/", getIndexPage());
        post("/buyLotto", postBuyLotto());
        post("/matchLotto", postMatchLotto());
    }

    private static Route getIndexPage() {
        return (request, response) -> render(new HashMap<>(), "index.html");
    }

    private static Route postBuyLotto() {
        return ((request, response) -> {
            int buyPrice = Integer.parseInt(request.queryParams("inputMoney"));
            int manualBuyNumber = request.queryParams("manualNumber").split("\n").length;

            LottoGame lottoGame = new LottoGame(buyPrice,manualBuyNumber);
            List<LottoSet> manualLottoSets = new ArrayList<>();
            Arrays.stream(request.queryParams("manualNumber").split("\n"))
                    .forEach(line ->
                            manualLottoSets.add(LottoSet.newInstance(Arrays.stream(line.split(","))
                                    .mapToInt(Integer::parseInt)
                                    .toArray()))
                    );

            lottoPaper = new LottoPaper(manualLottoSets, lottoGame.start());

            Map<String, Object> model = new HashMap<>();
            model.put("lottoTotalSize", lottoPaper.getLottoSetsSize());
            model.put("lottoSets",lottoPaper.getLottoSets());
            return render(model, "show.html");
        });
    }

    private static Route postMatchLotto() {
        return (request, response) -> {
            LottoSet winningLottoSet = LottoSet.newInstance(Arrays.stream(request.queryParams("winningNumber").split(","))
                    .map(LottoNumber::of)
                    .collect(Collectors.toList()));
            WinningLotto winningLotto = new WinningLotto(winningLottoSet, LottoNumber.of(request.queryParams("bonusNumber")));
            RankCount rankCount = new RankCount(lottoPaper, winningLotto);
            Map<String, Object> model = new HashMap<>();
            rankCount.getRankCount().keySet().stream()
                    .filter(rank -> rank.getCountOfMatch() != 0)
                    .sorted(Comparator.reverseOrder())
                    .forEach(rank -> model.put(rank.name(), rankCount.getNumberOfRankCount(rank)));
            model.put("profit", rankCount.calculateProfit());
            return render(model, "result.html");
        };
    }

    public static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}
