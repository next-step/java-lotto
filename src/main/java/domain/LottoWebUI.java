package domain;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import spark.utils.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

public class LottoWebUI {
    static Money money;
    static LottoCreate lottos = LottoCreate.from();

    public static void main(String[] args) {
        port(8080);

        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return render(model, "/index.html");
        });

        post("/buyLotto", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int inputMoney = Integer.parseInt(req.queryParams("inputMoney"));
            String str = req.queryParams("manualNumber");
            putLottos(inputMoney, str);
            model.put("no", money.turnOfAutoLotto() + money.turnOfManualLotto());
            model.put("lottos", lottos.generate(money));

            return render(model, "/show.html");
        });

        post("/matchLotto", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            String winningNo = req.queryParams("winningNumber");
            String bonusNo = req.queryParams("bonusNumber");

            LottoResult lottoResult = createLottoResult(winningNo, bonusNo);
            int sum = calcTotalSum(lottoResult);
            model.put("result1", lottoResult.getCount(Rank.FIFTH));
            model.put("result2", lottoResult.getCount(Rank.FOURTH));
            model.put("result3", lottoResult.getCount(Rank.THIRD));
            model.put("result4", lottoResult.getCount(Rank.SECOND));
            model.put("result5", lottoResult.getCount(Rank.FIRST));
            model.put("profit", Money.profitRatio(money.getMoney(), sum));

            return render(model, "/result.html");
        });
    }

    private static int calcTotalSum(LottoResult lottoResult) {
        int sum = 0;
        for(Map.Entry<Rank, Integer> entry : lottoResult.entrySet()) {
            Rank rank = entry.getKey();
            Integer integer = entry.getValue();
            sum += Money.sum(rank, integer);
        }
        return sum;
    }

    private static LottoResult createLottoResult(String winningNo, String bonusNo) {
        Lotto winning = Lotto.fromCommas(winningNo);
        WinningLotto winningLotto = WinningLotto.from(winning, Integer.parseInt(bonusNo));
        return lottos.match(winningLotto);
    }

    private static void putLottos(int inputMoney, String str) {
        String LottoNos[] = str.split("\n");
        int manual = LottoNos.length;
        if(StringUtils.isBlank(str)) {
            manual = 0;
        }
        money = Money.amountOfPurchase(inputMoney, manual);
        IntStream.range(0, money.turnOfManualLotto()).forEach(i -> lottos.getLottocreate().add(Lotto.fromCommas(LottoNos[i])));
    }

    public static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}
