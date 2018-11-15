import collection.PositiveNumber;
import lotto.model.*;
import lotto.view.InputView;
import lotto.view.ResultView;
import spark.ModelAndView;
import spark.Session;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static lotto.view.InputView.split;
import static lotto.view.InputView.toPositiveNums;
import static spark.Spark.*;

public class WebMain {

    private static String TICKETS = "tickets";
    private static String AMOUNT = "amount";

    public static void main(String[] args) {


        port(8080);
        staticFiles.location("/templates");
        post("/buyLotto", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            String inputMoney = req.queryParams("inputMoney");
            String manualNumber = req.queryParams("manualNumber");
            String[] manualNumbers = manualNumber.split("\r\n");

            Amount amount = InputView.createAmount(inputMoney);
            List<Ticket> manualTickets = InputView.createManualTickets(manualNumbers);
            amount.purcharseTicket(manualNumbers.length);
            Lotto lotto = new Lotto(amount, new LottosAutoGenerator());
            List<Ticket> tickets  = lotto.getTickets();

            model.put("manualNum", manualTickets.size());
            model.put("autoNum", tickets.size());
            tickets.addAll(manualTickets);
            model.put("ticketsNums",Ticket.getTicketsNums(tickets));

            Session session = req.session();
            session.attribute(TICKETS, tickets);
            session.attribute(AMOUNT, amount);
            return render(model, "/show.html");
        });

        post("/matchLotto", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            String winningNumber = req.queryParams("winningNumber");
            String bonusNumber = req.queryParams("bonusNumber");

            Session session = req.session();
            List<Ticket> tickets = (List<Ticket>) session.attribute(TICKETS);
            Amount amount = (Amount) session.attribute(AMOUNT);
            WinningTicket winningTicket = new WinningTicket(LottoNum.toLottoNums(toPositiveNums(split(winningNumber)))
                    , LottoNum.toLottoNum(new PositiveNumber(bonusNumber).getValue().intValue()));
            Statistics statistics = new Statistics(tickets, winningTicket);

            model.put("profitRate", amount.getProfitRate_100(statistics.getProfit()));
            model.put("results", ResultView.getResult(statistics));
            return render(model, "/result.html");
        });
    }

    public static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}
