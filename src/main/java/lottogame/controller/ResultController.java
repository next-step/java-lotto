package lottogame.controller;

import lottogame.domain.*;
import spark.Request;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static spark.Spark.post;

public class ResultController extends AbstractController {

    private static final String TEMPLATE_PATH = "result.html";

    public static void getResult() {

        post("/result", (req, res) -> {
            LottoTicket lottoTicket = req.session().attribute(req.ip());

            if (Objects.isNull(lottoTicket)) {
                redirectToIndex(res);
                return null;
            }

            try {
                LottoNumberPackage winningNumbers = getWinningNumbers(req);
                WinningInfo winningInfo = getWinningInfo(req, winningNumbers);
                LottoResult result = new LottoResult(new LottoResultMaker(lottoTicket, winningInfo));

                Map<String, Object> model = new HashMap<>();
                model.put("result", result);

                return render(model, TEMPLATE_PATH);

            } catch (IllegalArgumentException e) {
                redirectToIndex(res);
                return null;
            } finally {
                req.session().removeAttribute(req.ip());
            }
        });
    }

    private static LottoNumberPackage getWinningNumbers(Request req) {
        return new LottoNumberPackage(getInputLine(req, "winningNumbers"));
    }

    private static WinningInfo getWinningInfo(Request req, LottoNumberPackage winningNumbers) {
        return new WinningInfo(winningNumbers, getInputLine(req, "bonusNumber"));
    }
}
