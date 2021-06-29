package lottoAuto;

import lottoAuto.model.*;
import lottoAuto.view.InputView;
import lottoAuto.view.ResultView;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoAutoController {

    public static void main(String[] args) {
        int price = InputView.inputPrice();
        int amount = LottoCalculator.calculateAmount(price);
        ResultView.showAmount(amount);

        LottoGenerator lottoGenerator = new LottoGenerator(amount);
        Lottos lottos = new Lottos(lottoGenerator.getLottos());
        ResultView.showUserLotto(lottos);

        String winningLottoNumber = InputView.inputWinningNumber();
        int bonusBall = InputView.inputBonusBall();

        WinningLotto winningLotto = new WinningLotto(StringUtil.splitWinningNumber(winningLottoNumber), bonusBall);

        LottoResults lottoResults = lottos.matchWinningLotto(winningLotto);
        lottoResults.matchBonusBall(lottos, bonusBall);

        Revenue revenue = new Revenue(lottoResults.lottoRankCounting(),price);
        ResultView.showWinningStatistic(revenue);

        ResultView.showRevenue(revenue.calculateRevenue());
    }
}