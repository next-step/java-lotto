package lottogame;

import lottogame.domain.*;
import lottogame.view.WebInputHandler;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import spark.utils.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static spark.Spark.*;

public class WebApplicationLauncher {
    public static void main(String[] args) {

        port(8080);

        staticFiles.location("/templates");

        get("/", (req, res) -> {
            return renderIndex();
        });

        post( "/getLottoTicket", (req, res) -> {
            Map<String, Object> model = new HashMap<>();

            try {
                PurchaseAmount purchaseAmount = WebInputHandler.getPurchaseAmount(req);
                List<LottoNumberPackage> manualNumbers = WebInputHandler.getManualNumbers(req);

                if (Objects.isNull(purchaseAmount) || CollectionUtils.isEmpty(manualNumbers)) {
                    return renderIndex();
                }

                PurchaseCount purchaseCount = WebInputHandler.getPurchaseCount(purchaseAmount, manualNumbers);
                LottoTicket lottoTicket = WebInputHandler.getLottoTicket(purchaseAmount, manualNumbers, purchaseCount);

                req.session().attribute(req.ip(), lottoTicket);
                model.put("lottoTicket", lottoTicket);

                return render(model, "show.html");

            } catch (IllegalArgumentException e) {
                return renderIndex();
            }
        });

        post( "/getResult", (req, res) -> {

            try {
                LottoTicket lottoTicket = req.session().attribute(req.ip());

                if (Objects.isNull(lottoTicket)) {
                    return renderIndex();
                }

                LottoNumberPackage winningNumbers = WebInputHandler.getWinningNumbers(req);
                WinningInfo winningInfo = WebInputHandler.getWinningInfo(req, winningNumbers);
                LottoResult result = new LottoResult(new LottoResultMaker(lottoTicket, winningInfo));

                Map<String, Object> model = new HashMap<>();
                model.put("result", result);

                return render(model, "result.html");

            } catch (IllegalArgumentException e) {
                return renderIndex();
            } finally {
                req.session().removeAttribute(req.ip());
            }
        });

    }

    public static Object renderIndex() {
        return render(null, "index.html");
    }

    public static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}
