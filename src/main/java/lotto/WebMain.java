package lotto;

import static spark.Spark.exception;
import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import lotto.domain.LottoPrize;
import lotto.domain.LottoRequest;
import lotto.domain.LottoResult;
import lotto.domain.LottoStore;
import lotto.domain.LottoTicket;
import lotto.domain.Money;
import lotto.domain.WInningLottoRequest;
import lotto.domain.lottoMachine.DefaultLottoMachine;
import lotto.view.web.CustomHandlebarsTemplateEngine;
import spark.ModelAndView;
import spark.Request;

public class WebMain {
    private static LottoStore lottoStore = new LottoStore(new DefaultLottoMachine());
    
    public static void main(String[] args) {
        webserverConfigure();
        routes();
    }

    private static void routes() {
        get("/", (req, res) -> {
            req.session(true);
            return render(null, "/index.html");
        });

        post("/buyLotto", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            LottoRequest lottoRequest = new LottoRequest(getMoney(req), getManualNumbers(req));

            LottoTicket lottoTicket = lottoStore.buyTickets(lottoRequest);

            req.session().attribute("lottoTicket", lottoTicket);
            req.session().attribute("money", lottoRequest.getMoney());

            model.put("autoLottoCount", lottoTicket.getAutoLottoCount());
            model.put("manualLottoCount", lottoTicket.getManualLottoCount());
            model.put("lottos", lottoTicket.getAllLotto());
            return render(model, "/show.html");
        });

        post("/matchLotto", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            WInningLottoRequest request = new WInningLottoRequest(getWinningNumber(req), getBonusNumber(req));
            Money money = req.session().attribute("money");
            LottoTicket lottoTicket = req.session().attribute("lottoTicket");
            LottoResult lottoResult = lottoStore.checkWinningLotto(request, lottoTicket);
            model.put("lottoPrizes", LottoPrize.valuesWithoutNone());
            model.put("lottoResult", lottoResult);
            model.put("profitRate", money.calcurateProfitRate(lottoResult.getTotalPrize()) );
            return render(model, "/result.html");
        });

        exception(RuntimeException.class, (exception, request, response) -> {
            System.out.println(exception);
            response.redirect("/");
        });
    }

    private static Integer getBonusNumber(Request req) {
        return Optional.ofNullable(req.queryParams("bonusNumber")).map(v -> Integer.parseInt(v))
                .orElseThrow(IllegalArgumentException::new);
    }

    private static String getWinningNumber(Request req) {
        return Optional.ofNullable(req.queryParams("winningNumber")).orElseThrow(IllegalArgumentException::new);
    }

    private static String[] getManualNumbers(Request req) {
        return Optional.ofNullable(req.queryParams("manualNumber")).map(v -> v.split("\n")).orElseGet(()->null);
    }

    private static Money getMoney(Request req) {
        return Optional.ofNullable(req.queryParams("inputMoney")).map(v -> Money.of(Integer.valueOf(v)))
                .orElseThrow(IllegalArgumentException::new);
    }

    public static String render(Map<String, Object> model, String templatePath) {
        return new CustomHandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
    
    private static void webserverConfigure() {
        port(8080);
    }
}
