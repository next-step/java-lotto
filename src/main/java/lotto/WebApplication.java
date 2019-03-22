package lotto;

import lotto.domain.LottoStore;
import lotto.domain.lotto.LottoBundle;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.Ticket;
import lotto.domain.lotto.TicketMachine;
import lotto.domain.lotto.WinningLotto;
import lotto.enums.Rank;
import lotto.utils.ManualLottoGenerator;
import lotto.utils.RandomLottoGenerator;
import lotto.view.LottoResult;
import lotto.view.vo.MatchResult;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

public class WebApplication {
    private static final String REGEX = ",";
    private static LottoBundle lottoBundle;
    private static int money;

    public static void main(String[] args) {
        port(8080);

        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return render(model, "/index.html");
        });

        post("/buyLotto", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            money = Integer.parseInt(req.queryParams("inputMoney"));
            int manualCount = Integer.parseInt(req.queryParams("manualCount"));
            List<String> manualLottoNumbers = Arrays.asList(req.queryParams("manualNumber").split("\\n"));
            List<Ticket> manualLottoTickets = TicketMachine.generateTickets(manualLottoNumbers, REGEX);
            LottoStore lottoStore =
                new LottoStore(new ManualLottoGenerator(), new RandomLottoGenerator(), money, manualLottoTickets);

            lottoBundle = lottoStore.buyManualLottos(manualLottoTickets);
            lottoBundle.addAll(lottoStore.buyRandomLottos());

            model.put("lottos", lottoBundle.getLottos());
            model.put("manualCount", manualCount);
            model.put("autoCount", lottoBundle.getLottos().size() - manualCount);
            return render(model, "/show.html");
        });

        post("/matchLotto", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            String winningLottoNumber = req.queryParams("winningNumber");
            Ticket winningLottoTicket = TicketMachine.generateTicket(winningLottoNumber, REGEX);
            int bonusNumber = Integer.parseInt(req.queryParams("bonusNumber"));

            WinningLotto winningLotto = new WinningLotto(winningLottoTicket, new LottoNumber(bonusNumber));

            LottoResult lottoResult = new LottoResult(winningLotto);
            MatchResult matchResult = lottoResult.generate(lottoBundle);
            List<String> results = new ArrayList<>();
            for (Rank rank : Rank.values()) {
                results.add(rank.toString() + matchResult.getCountInfo().getCounts().get(rank).toString());
            }

            model.put("matchResult", results);
            model.put("rewardPercent", lottoResult.getRewardPercent(money));
            return render(model, "/result.html");
        });
    }

    public static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}
