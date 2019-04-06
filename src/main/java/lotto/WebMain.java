package lotto;

import lotto.domain.*;
import lotto.view.ResultView;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.*;
import java.util.stream.Collectors;

import static spark.Spark.*;

public class WebMain {
    private static List<Lotto> lottos;

    public static void main(String[] args) {
        port(8080);


        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return render(model, "/index.html");
        });

        get("/helloworld", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("name", "pobi");
            return render(model, "/index.html");
        });

        post("/buyLotto", (req, res) -> {
            Set<String> params = req.queryParams();
            String inputMoney = req.queryParams("inputMoney");
            String manualNumbers = req.queryParams("manualNumber");
            List<String> manualLottoNumbers = new ArrayList<>();
            int manualQuantity = 0;
            if(manualNumbers.length() > 0) {
                String[] numbers = manualNumbers.split("\r\n");
                manualLottoNumbers = Arrays.asList(numbers);
                manualQuantity = manualLottoNumbers.size();
            }
            Money money = new Money(Integer.parseInt(inputMoney));
            int quantity = money.purchaseQuantity();
            int autoQuantity = quantity - manualQuantity;

            LottoMachine lottoMachine = new LottoMachine();
            lottos = lottoMachine.getAllLotto(autoQuantity, manualLottoNumbers);
            List<String> lottoNumbers = lottos.stream().map(Lotto::toString).collect(Collectors.toList());
            Map<Integer, String> showLottos = new HashMap<>();

            Map<String, Object> model = new HashMap<>();
            model.put("autoQuantity", autoQuantity);
            model.put("manualQuantity", manualQuantity);
            model.put("lottos", lottoNumbers);
            return render(model, "/show.html");
        });

        post("/matchLotto", (req, res) -> {
           Map<String, Object> model = new HashMap<>();
           String winningNumber = req.queryParams("winningNumber");
           String bonusNumber = req.queryParams("bonusNumber");
           String[] winning = Utils.stringSplitWithDelimiter(winningNumber, ",");
           LottoNumbers winningNumbers = new LottoNumbers(Utils.arrayToSet(winning));
           LottoNumber bonusBall = new LottoNumber(Integer.parseInt(bonusNumber));
           WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers(winningNumbers, bonusBall);

           LottoResult lottoResult = new LottoResult(lottos, winningLottoNumbers);
           List<String> results = new ArrayList<>();
           ResultView resultView = new ResultView();

           List<WinningType> winningTypes = Arrays.stream(WinningType.values())
                   .filter(winningType -> winningType.getMatchCount() > 0)
                   .sorted((a, b) -> Integer.compare(b.getRank(), a.getRank()))
                   .collect(Collectors.toList());
           for(WinningType winningType : winningTypes) {
               results.add(resultView.printBonus(lottoResult, winningType));
           }

           model.put("results", results);
           model.put("earningsRate", lottoResult.earningsRate());

           return render(model, "/result.html");
        });
    }

    public static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}
