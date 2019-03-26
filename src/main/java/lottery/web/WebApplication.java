package lottery.web;

import lottery.domain.*;
import lottery.machine.LotteryMachine;
import lottery.web.view.InputView;
import lottery.web.view.ResultView;
import spark.ModelAndView;
import spark.TemplateEngine;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class WebApplication {

    static final TemplateEngine templateEngine = new HandlebarsTemplateEngine();

    static final LotteryMachine machine = new LotteryMachine();

    public static void main(String[] args) {
        port(8080);

        indexController();

        gameController();
    }

    private static void gameController() {
        post("/buyLotto", (req, res) -> {
            final Money price = InputView.inputPrice(req);
            final List<LotteryTicket> selectedTickets = InputView.inputSelectTickets(req);
            final List<LotteryTicket> boughtTickets = machine.buyLotteryTicket(price, selectedTickets);

            Map<String, Object> model = new HashMap<>();
            final WinningTicket winningTicket = InputView.inputWinningTicket();
            LotteryWinningStatistics statistics = machine.raffle(winningTicket);

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
