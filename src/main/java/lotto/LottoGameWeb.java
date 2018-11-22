package lotto;

import lotto.model.*;
import lotto.util.MessageConverter;
import lotto.view.InputView;
import lotto.view.QuestionType;
import spark.ModelAndView;

import java.util.*;
import java.util.stream.Collectors;

import static spark.Spark.*;

public class LottoGameWeb {
    private static List<Lotto> lottos;

    public static void main(String args[]) {
        port(8080);

        get("/", (req, res) -> render(null, "/index.html"));

        post("/buyLotto", (req, res) -> {
            Money money = Money.from(Integer.parseInt(req.queryParams("inputMoney")));
            List<String> manualStrings = Arrays.asList(req.queryParams("manualNumber").split("/n"));

            LottoGame lottoGame = new LottoGame(money);
            lottos = lottoGame.buy(
                new ManualLottosGenerator(manualStrings),
                new AutoLottosGenerator());

            Map<String, Object> model = new HashMap<>();
            model.put("lottosCount", lottos.size());
            model.put("lottos", lottos);
            return render(model, "/show.html");
        });

        post("/matchLotto", (req, res) -> {
            WinningLotto winningLotto = WinningLotto.from(
                Lotto.fromComma(req.queryParams("winningNumber")),
                LottoNumber.from(Integer.parseInt(req.queryParams("bonusNumber"))));
            Statistics statistics = new Statistics(lottos, winningLotto);
            Map<Rank, Integer> countOfRank = statistics.getCountOfRank();
            List<String> rankMessages = countOfRank.keySet().stream()
                .sorted(Comparator.reverseOrder())
                .filter(rank -> rank.getCountOfMatch() != 0)
                .map(rank -> MessageConverter.convertToMatchMessage(rank, countOfRank.get(rank)))
                .collect(Collectors.toList());

            Map<String, Object> model = new HashMap<>();
            model.put("rankMessages", rankMessages);
            model.put("returnsOfInvestment", statistics.getReturnsOfInvestment());
            return render(model, "/result.html");
        });
    }

    public static String render(Map<String, Object> model, String templatePath) {
        return new CustomHandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}
