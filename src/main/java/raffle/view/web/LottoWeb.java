package raffle.view.web;

import raffle.domain.lotto.Lotto;
import raffle.domain.lotto.LottoMachine;
import raffle.domain.lotto.LottoNo;
import raffle.domain.lotto.money.Money;
import raffle.domain.lotto.win.LottoResult;
import raffle.domain.lotto.win.LottosCreation;
import raffle.view.console.InputView;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.*;
import java.util.stream.Collectors;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

public class LottoWeb {

    public static void main(String[] args) {
        port(8080);

        get("/", (req, res) -> render(new HashMap<>(), "/index.html"));

        post("/buyLotto", (req, res) -> {
            Map show = new HashMap();
            int inputMoney = Integer.parseInt(req.queryParams("inputMoney"));
            String[] manualNumber = req.queryParams("manualNumber").split("\r\n");
            List<Lotto> lottos = new ArrayList<>();
            for(String lotto : manualNumber){
                lottos.add(new Lotto(Arrays.stream(lotto.split(",")).map(String::trim).map(Integer::parseInt).map(LottoNo::in).collect(Collectors.toList())));
            }

            Money money = new Money(lottos.size(), inputMoney);

            LottoMachine lottoMachine = new LottoMachine(money , new LottosCreation(lottos));

            show.put("lottos", lottoMachine.getLottos());
            show.put("lottosSize", lottoMachine.getLottos().size());

            req.session().attribute("lottoMachine", lottoMachine);

            return render(show, "/show.html");
        });

        post("/matchLotto", (req, res) -> {
            Map show = new HashMap();

            String winningNumber = req.queryParams("winningNumber");
            int bonusNumber = Integer.parseInt(req.queryParams("bonusNumber"));

            LottoMachine lottoMachine = req.session().attribute("lottoMachine");
            LottoResult lottoResult = lottoMachine.winLotto(Arrays.stream(winningNumber.split(",")).map(String::trim).map(Integer::parseInt).map(LottoNo::in).collect(Collectors.toList()), LottoNo.in(bonusNumber));

            show.put("lottoResult" ,lottoResult);
            return render(show, "/result.html");
        });
    }

    public static String render(Map<String, Object> model, String templatePath) {
        return new CustomResultTemplateEngine().render(new ModelAndView(model, templatePath));
    }

}
