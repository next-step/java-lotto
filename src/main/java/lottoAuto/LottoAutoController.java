package lottoAuto;

import lottoAuto.model.*;
import lottoAuto.view.InputView;
import lottoAuto.view.ResultView;

import java.math.BigDecimal;
import java.util.Map;

public class LottoAutoController {

    public static void main(String[] args) {
        int price = InputView.inputPrice();
        int amount = LottoCalculator.calculateAmount(price);
        ResultView.showAmount(amount);

        Lottos lottos = new Lottos(amount);
        ResultView.showUserLotto(lottos);

        String winningLottoNumber = InputView.inputWinningNumber();
        int bonusBall = InputView.inputBonusBall();

        WinningLotto winningLotto = new WinningLotto(StringUtil.splitWinningNumber(winningLottoNumber), bonusBall);

        LottoResults lottoResults = lottos.matchWinningLotto(winningLotto);
        lottoResults.matchBonusBall(lottos, bonusBall);

        Map<Rank, Long> resultMap = lottoResults.lottoRankCounting();
        ResultView.showWinningStatistic(resultMap);

        BigDecimal revenue = LottoCalculator.getRevenue(price, resultMap);
        ResultView.showRevenue(revenue);
    }
}