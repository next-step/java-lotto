import domain.*;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import util.StringParser;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static spark.Spark.*;

public class WebMain {
    public static void main(String[] args) {
        port(8080);

        get("/", (request, response) -> render(null, "/index.html"));

        post("/buyLotto", (request, response) -> {
            Map<String, Object> model = new HashMap<>();

            Integer inputMoney = Integer.parseInt(request.queryParams("inputMoney"));
            List<Integer[]> manualNumbers = Arrays.stream(request.queryParams("manualNumber").split("\n"))
                .map(StringParser::strToIntegerArray)
                .collect(Collectors.toList());

            LottoMoney lottoMoney = new LottoMoney(inputMoney);
            LottoGenerator lottoGenerator = new DefaultLottoGenerator(lottoMoney, manualNumbers);
            List<Lotto> lottos = lottoGenerator.generate();

            request.session().attribute("lottoMoney", lottoMoney);
            request.session().attribute("lottos", lottos);

            model.put("manualCount", manualNumbers.size());
            model.put("autoCount", lottoMoney.getLottoCount() - manualNumbers.size());
            model.put("lottos", lottos);

            return render(model, "/show.html");
        });

        post("/matchLotto", (request, response) -> {
            Map<String, Object> model = new HashMap<>();

            Integer[] winningNumber = StringParser.strToIntegerArray(request.queryParams("winningNumber"));
            Integer bonusNumber = Integer.parseInt(request.queryParams("bonusNumber"));

            LottoMoney lottoMoney = request.session().attribute("lottoMoney");
            List<Lotto> lottos = request.session().attribute("lottos");

            WinningLotto winningLotto = new WinningLotto(winningNumber, bonusNumber);

            LottoResult lottoResult = new LottoResult(lottos, winningLotto);

            model.put("rankGroup", lottoResult.getRankGroup());
            model.put("profitRate", lottoMoney.calculateProfitRate(lottoResult.calculatePrizeMoney()));

            return render(model, "/result.html");
        });
    }

    private static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}
