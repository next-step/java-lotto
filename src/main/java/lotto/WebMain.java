package lotto;

import lotto.domain.*;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.*;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

public class WebMain {

    public static void main(String[] args) {
        port(8080);

        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return render(model, "/index.html");
        });

        post("/buyLotto", (req, res) -> {
            Map<String, Object> model = new HashMap<>();

            String inputMoney = req.queryParams("inputMoney");
            String manualNumber = req.queryParams("manualNumber");

            String[] manualLottos = manualNumber.split("\r\n");

            LottoCountManager lottoCountManager = new LottoCountManager(
                    Integer.parseInt(inputMoney), manualLottos.length);

            req.session().attribute("lottoCountManager", lottoCountManager);

            BundleLotto lottos = new LottoGame(Arrays.asList(manualLottos)).generateLottoNumber(lottoCountManager);
            req.session().attribute("bundleLotto", lottos);
            model.put("manualCount", lottoCountManager.getManualCount());
            model.put("autoCount", lottoCountManager.getAutoLottoCount());

            List<String> lottoNumbers = new ArrayList<>();
            for (Lotto lotto : lottos.getLottos()) {
                StringBuilder sb = new StringBuilder();
                sb.append("[ ");
                for (LottoNo lottoNo : lotto.getLottoNumbers()) {
                    sb.append(lottoNo.getLottoNumber()+", ");
                }
                String s = sb.substring(0, sb.lastIndexOf(",")) + " ]";
                lottoNumbers.add(s);
            }
            model.put("lottoNumbers", lottoNumbers);
            return render(model, "/show.html");
        });

        post("/matchLotto", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            String winningNumber = req.queryParams("winningNumber");
            String bonusBall = req.queryParams("bonusNumber");
            WinningLotto winningLotto = new WinningLotto(Lotto.manual(winningNumber),
                    Integer.parseInt(bonusBall));

            LottoGameResult lottoGameResult = new LottoGameResult();

            BundleLotto lottos = req.session().attribute("bundleLotto");
            lottoGameResult.doCalculateLottoResult(lottos, winningLotto);

            List<LottoDto> lottoDtos = new ArrayList<>();
            for (LottoDto lottoDto : lottoGameResult.getLottoDtos()) {
                lottoDtos.add(lottoDto);
            }

            model.put("lottoDtos", lottoDtos);
            LottoCountManager lottoCountManager = req.session().attribute("lottoCountManager");
            String ratio = lottoGameResult.getRatio(lottoGameResult.getLottoDtos(), lottoCountManager);
            int ratioPercentage = (int)(Double.valueOf(ratio) * 100);
            model.put("ratio", ratioPercentage);

            return render(model, "/result.html");
        });

    }

    public static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}
