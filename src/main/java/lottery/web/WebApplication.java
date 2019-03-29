package lottery.web;

import lottery.domain.LotteryTicket;
import lottery.domain.LotteryWinningStatistics;
import lottery.domain.Money;
import lottery.domain.WinningTicket;
import lottery.machine.LotteryRaffleMachine;
import lottery.machine.LotteryVendingMachine;
import lottery.supplier.BoundedUniqueRandomNumbersGenerator;
import lottery.web.view.InputView;
import lottery.web.view.ResultView;
import spark.ModelAndView;
import spark.TemplateEngine;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static lottery.domain.LotteryNumber.LOWER_BOUND_INCLUSIVE;
import static lottery.domain.LotteryNumber.UPPER_BOUND_INCLUSIVE;
import static spark.Spark.*;

public class WebApplication {

    static final TemplateEngine templateEngine;

    static final LotteryVendingMachine vendingMachine;

    static {
        templateEngine = new HandlebarsTemplateEngine();
        vendingMachine = new LotteryVendingMachine(
                new BoundedUniqueRandomNumbersGenerator(LOWER_BOUND_INCLUSIVE, UPPER_BOUND_INCLUSIVE));
    }

    public static void main(String[] args) {
        port(8080);

        indexController();

        gameController();
    }

    private static void gameController() {
        post("/buyLotto", (req, res) -> {
            final Money price = InputView.inputPrice(req);
            final List<LotteryTicket> selectedTickets = InputView.inputSelectTickets(req);
            final List<LotteryTicket> boughtTickets = vendingMachine.buyLotteryTicket(price, selectedTickets);
            final LotteryRaffleMachine raffleMachine = new LotteryRaffleMachine(boughtTickets);

            final Map<String, Object> model = new HashMap<>();
            final WinningTicket winningTicket = InputView.inputWinningTicket();
            final LotteryWinningStatistics statistics = raffleMachine.raffle(winningTicket);

            ResultView.viewStatistics(model, statistics);

            return render(model, "/result.html");
        });
    }

    private static void indexController() {
        get("/", (req, res) ->  render(null, "/index.html"));
    }

    private static String render(Map<String, Object> model, String templatePath) {
        return templateEngine.render(new ModelAndView(model, templatePath));
    }
}
