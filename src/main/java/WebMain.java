import domain.*;
import domain.lottosGenerator.AutoLottosGenerator;
import domain.lottosGenerator.ManualLottosGenerator;
import domain.winningStatus.WinningStatus;
import spark.ModelAndView;

import java.util.*;

import static spark.Spark.*;

public class WebMain {
    public static void main(String[] args) {
        port(8080);

        get("/", (request, response) -> render(Collections.emptyMap(), "index.html"));

        post("/buyLotto", (request, response) -> {
            String inputMoney = request.queryParams("inputMoney");
            String manualNumber = request.queryParams("manualNumber");

            LottoGames lottoGames = purchase(inputMoney, splitManualNumbers(manualNumber));

            Map<String, Object> model = new HashMap<>();
            model.put("games", lottoGames.getGames());
            model.put("count", lottoGames.getGames().size());

            request.session().attribute("lottoGames", lottoGames);

            return render(model, "show.html");
        });

        post("/matchLotto", (request, response) -> {
            String inputWinningNumber = request.queryParams("winningNumber");
            String bonusNumber = request.queryParams("bonusNumber");

            LottoGames lottoGames = request.session().attribute("lottoGames");

            WinningNumber winningNumber = new WinningNumber(
                Lotto.fromCommaString(inputWinningNumber),
                new LottoNumber(Integer.valueOf(bonusNumber)));

            WinningStatus status = lottoGames.match(winningNumber);

            Map<String, Object> model = new HashMap<>();
            model.put("winningStatus", resultCounts(status));
            model.put("profit", (int) (status.getProfit() * 100));

            return render(model, "result.html");
        });
    }

    public static String render(Map<String, Object> model, String templatePath) {
            return new CustomHandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }

    private static List<String> splitManualNumbers(String input) {
        if (input.isEmpty()) {
            return Collections.emptyList();
        }

        return Arrays.asList(input.split("\\n"));
    }

    private static LottoGames purchase(String inputMoney, List<String> manualNumbers) {
        LottoMachine lottoMachine = new LottoMachine();

        Money amount = new Money(Integer.valueOf(inputMoney));
        List<Lotto> manualGames = lottoMachine.purchaseLotto(amount, new ManualLottosGenerator(manualNumbers));

        Money autoMoney = amount.remain(manualGames.size());
        List<Lotto> autoGames = lottoMachine.purchaseLotto(autoMoney, new AutoLottosGenerator());

        manualGames.addAll(autoGames);

        LottoGames lottoGames = new LottoGames();
        manualGames.forEach(lottoGames::add);

        return lottoGames;
    }

    private static List<String> resultCounts(WinningStatus status) {
        List<String> result = new ArrayList<>();

        for (Prize prize : Prize.values()) {
            if (prize == Prize.NONE) continue;

            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(prize.getToWin()).append("개 일치");
            if (prize.getRequireBonus()) {
                stringBuilder.append(", 보너스 볼 일치");
            }
            stringBuilder.append(" (").append(prize.getReward()).append(") - ");
            stringBuilder.append(status.getPrizeCount(prize)).append("개");

            result.add(stringBuilder.toString());
        }

        return result;
    }
}
