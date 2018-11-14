package game.lotto;

import game.lotto.model.*;
import spark.ModelAndView;
import spark.Session;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.*;
import java.util.stream.Collectors;

import static spark.Spark.*;

public class LottoWeb {

    public static void main(String[] args) {
        port(8080);

        get("/", (req, res) -> render(null,"/index.html"));

        post("/buyLotto", (req, res) -> {
            String inputMoney = req.queryParams("inputMoney");
            String manualNumber = req.queryParams("manualNumber");

            Money money = new Money(Integer.parseInt(inputMoney));
            List<String> manualNumbers = Arrays.stream(manualNumber.split("\\\r?\\\n")).map(String::trim).collect(Collectors.toList());

            Amount amount = new Amount(money, manualNumbers.size());
            LottosGenerator generator = new ComplexLottosGenerator(
                    new AutoLottosGenerator(amount),
                    new ManulLottosGenerator(manualNumbers)
            );

            List<Lotto> lottos = generator.generate();

            Session session = req.session();
            session.attribute("lottos", lottos);

            Map<String, Object> model = new HashMap<>();
            model.put("lottos", lottos);
            model.put("amount", amount);
            return render(model, "/show.html");
        });

        post("/matchLotto", (req, res) -> {
            String winningNumber = req.queryParams("winningNumber");
            String bonusNumber = req.queryParams("bonusNumber");
            List<Lotto> lottos = req.session().attribute("lottos");

            LottoGame lottoGame = new LottoGame(lottos);
            Set<LottoNumber> winningLottoNumbers = LottoNumberFactory.createLottoNumbers(winningNumber);
            LottoNumber bonus = new LottoNumber(Integer.parseInt(bonusNumber));
            WinningLotto winningLotto = new WinningLotto(Lotto.manual(winningLottoNumbers), bonus);

            MatchResult matchResult = lottoGame.match(winningLotto);
            Report report = matchResult.makeReport(new Money(lottos.size() * Money.LOTTO_PRICE));

            return render(Collections.singletonMap("report", report), "/result.html");
        });
    }


    public static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }

}
