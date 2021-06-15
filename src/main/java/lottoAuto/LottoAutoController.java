package lottoAuto;

import lottoAuto.model.*;
import lottoAuto.view.InputView;
import lottoAuto.view.ResultView;

import java.math.BigDecimal;
import java.util.Map;

public class LottoAutoController {

    public static void main(String[] args) {
        LottoAuto lottoAuto = new LottoAuto();

        int price = InputView.inputPrice();
        int amount = lottoAuto.calculateAmount(price);
        ResultView.showAmount(amount);

        UserLottos userLottos = lottoAuto.inputUserLottoNumber(amount);
        ResultView.showUserLotto(userLottos);

        String winningLottoString = InputView.inputWinningNumber();
        int bonusBall = InputView.inputBonusBall();

        WinningLotto winningLotto = lottoAuto.inputWinningNumber(winningLottoString,bonusBall);

        LottoResults lottoResults = new LottoResults(userLottos,winningLotto,bonusBall);
        Map<Rank,Long> resultMap = lottoResults.lottoRankCounting();

        ResultView.showWinningStatistic(resultMap);
        BigDecimal revenue = lottoResults.getRevenue(price,resultMap);
        ResultView.showRevenue(revenue);
    }
}