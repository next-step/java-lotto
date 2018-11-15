package ui;

import domain.*;
import domain.wrapper.BuyLotto;
import domain.wrapper.EarningRate;
import domain.wrapper.LottoNo;
import domain.wrapper.Money;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import utils.LottoNumberGenerator;
import utils.StringUtils;
import view.InputView;
import view.ResultView;
import view.WebResultView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

public class WebUI {
    public static void main(String[] args) {
        port(8080);

        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return render(model, "/index.html");
        });

        post("/buyLotto", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            Money money = new Money(Integer.parseInt(req.queryParams("inputMoney")));
            String manualNumber = req.queryParams("manualNumber");
            String[] stringTokens = manualNumber.split(System.getProperty("line.separator"));

            BuyLotto buyManualLottoCount = new BuyLotto(stringTokens.length);
            List<Lotto> manualLottoNumbers = new ArrayList<>();
            for(int i =0; i <stringTokens.length; i++){
                manualLottoNumbers.add(new Lotto(stringTokens[i]));
            }
            money.subtract(buyManualLottoCount);

            req.session().attribute("money",money);
            req.session().attribute("lottoGroup",manualLottoNumbers);
            model.put("manualLottoNumbers", manualLottoNumbers);
            model.put("size", manualLottoNumbers.size());
            return render(model, "/show.html");
        });

        post("/matchLotto", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            Money money =(Money)req.session().raw().getAttribute("money");
            String winningNumber = req.queryParams("winningNumber");
            String bonusNumber = req.queryParams("bonusNumber");

            List<Lotto> manualLottoNumbers = req.session().attribute("lottoGroup");
            LottoGroup lottoGroup = new LottoGroup(manualLottoNumbers);

            Lotto lastLotto = new Lotto(StringUtils.convertStrToNum(winningNumber));
            LottoNo bonusNum = new LottoNo(Integer.parseInt(bonusNumber)) ;
            WinningLotto winningLotto = new WinningLotto(lastLotto, bonusNum);

            LottoResultGroup combineLottoGroup = lottoGroup.getCombineLottos(winningLotto);
            //결과
            List<String> lottoRankResults = WebResultView.getResults(combineLottoGroup);
            model.put("results", lottoRankResults);

            //수익률
            Money totalRewards = combineLottoGroup.getTotalReward();
            EarningRate totalEarningRate = new EarningRate(money,totalRewards);
            model.put("rate", WebResultView.getTotalRate(totalEarningRate));
            return render(model, "/result.html");
        });

    }

    public static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }

}
