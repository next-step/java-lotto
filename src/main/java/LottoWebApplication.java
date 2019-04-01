import domain.*;
import domain.generator.AutoLotto;
import domain.generator.ManualLotto;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.*;
import java.util.stream.Collectors;

import static spark.Spark.*;

public class LottoWebApplication {
    public static void main(String[] args) {
        port(8080);

        get("/", (req, res) -> render(null, "/index.html"));

        post( "/buyLotto", (req, res) -> {
            List<String> manualNumber = Arrays.asList(req.queryParams("manualNumber").split("\r\n"));
            List<Lotto> lottos = new ArrayList<>();
            int lottoPaper = new Money( Integer.parseInt(req.queryParams("inputMoney"))).calcPaper();

            manualNumber.forEach(numbers ->
                    lottos.add(new ManualLotto(
                            Arrays.stream(numbers.trim().split(","))
                                    .map(Integer::parseInt)
                                    .collect(Collectors.toList()))
                            .generate()));

            for (int i = 0; i < lottoPaper - manualNumber.size(); i++) {
                lottos.add(new AutoLotto().generate());
            }

            Map<String, Object> model = new HashMap<>();
            model.put("lottoPaper", lottoPaper);
            model.put("lottos", lottos.subList(0, lottoPaper));

            return render(model, "/show.html");
        });

        post( "/matchLotto", (req, res) -> {
            List<String> lottonumbers = new ArrayList<>();
            Arrays.asList(req.queryParamsValues("lottos")).forEach(lotto -> lottonumbers.add(lotto.trim().substring(1, lotto.length() - 1)));

            List<Lotto> lottos = new ArrayList<>();
            lottonumbers.forEach(numbers ->
                    lottos.add(new ManualLotto(
                            Arrays.stream(numbers.split(", "))
                                    .map(Integer::parseInt)
                                    .collect(Collectors.toList()))
                            .generate()));

            List<Integer> winning = Arrays.stream(req.queryParams("winningNumber").trim().split(",")).map(Integer::parseInt).collect(Collectors.toList());
            WinningNumbers winningNumbers = new WinningNumbers(LottoNumbers.convertToLottoNo(winning), Integer.parseInt(req.queryParams("bonusNumber")));
            LottoResult lottoResult = new LottoResult(lottos, winningNumbers);

            Map<String, Object> model = new HashMap<>();
            model.put("profit", new Profit(lottoResult).calcProfile(lottos.size()));
            model.put("first", lottoResult.lottoMatchCount(LottoRank.FIRST));
            model.put("second", lottoResult.lottoMatchCount(LottoRank.SECOND));
            model.put("third", lottoResult.lottoMatchCount(LottoRank.THIRD));
            model.put("fourth", lottoResult.lottoMatchCount(LottoRank.FOURTH));
            model.put("fifth", lottoResult.lottoMatchCount(LottoRank.FIFTH));

            return render(model, "/result.html");
        });
    }

    public static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}