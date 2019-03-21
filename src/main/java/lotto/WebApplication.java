package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoMarket;
import lotto.domain.LottoProfit;
import lotto.dto.LottoStatistics;
import lotto.view.LottoInputView;
import lotto.vo.LottoWinningNumber;
import lotto.web.WebInputView;
import lotto.web.WebOutputView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class WebApplication {

    private static LottoMachine lottoMachine = LottoMachine.getInstance();

    private static List<Lotto> lottos;
    private static LottoProfit lottoProfit;

    public static void main(String[] args) {
        staticFileLocation("templates");

        get("/", (req, res) -> "index.html");

        post("/buyLotto", (req, res) -> {
            //구매금액
            int buyAmount = Integer.parseInt(req.queryParams("inputMoney"));

            //수동구매번호
            List<String[]> directNumbers = WebInputView.inputDirectNumbers(req.queryParams("manualNumber"));

            //수동입력 번호 생성
            lottos = LottoMarket.createDirectNumbers(directNumbers);

            //구매수익 set
            lottoProfit = new LottoProfit(directNumbers.size(), buyAmount);

            //로또 생성
            LottoMarket.createLottos(lottos, lottoProfit.getBuyAutoCount());

            WebOutputView webOutputView = new WebOutputView();
            Map<String, Object> model = new HashMap<>();
            model.put("lottos", webOutputView.lottosToStringList(lottos));
            model.put("buyCount", lottoProfit.getBuyAutoCount() + lottoProfit.getBuyDirectCount());

            return webOutputView.render(model, "show.html");

        });

        post("/matchLotto", (req, res) -> {

            //당첨번호 입력
            String[] splitWinningNumbers = WebInputView.splitLottoNumbers(req.queryParams("winningNumber"));

            //보너스 번호 입력
            int bonusNumber = Integer.parseInt(req.queryParams("bonusNumber"));

            //당첨번호 생성
            LottoWinningNumber lottoWinningNumber = LottoInputView.createWinningNumbers(splitWinningNumbers, bonusNumber);

            //당첨통계
            LottoStatistics lottoStatistics = lottoMachine.getLottoStatistics(lottos, lottoWinningNumber, lottoProfit);

            WebOutputView webOutputView = new WebOutputView();
            Map<String, Object> model = new HashMap<>();
            model.put("firstCount", lottoStatistics.getLottoMatchCount().getFirstCnt());
            model.put("secondCount", lottoStatistics.getLottoMatchCount().getSecondCnt());
            model.put("thirdCount", lottoStatistics.getLottoMatchCount().getThirdCnt());
            model.put("forthCount", lottoStatistics.getLottoMatchCount().getForthCnt());
            model.put("fifthCount", lottoStatistics.getLottoMatchCount().getFifthCnt());
            model.put("profit", webOutputView.calculateProfit(lottoProfit.getProfit()));

            return webOutputView.render(model, "result.html");
        });
    }

}
