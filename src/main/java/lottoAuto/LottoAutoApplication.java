package lottoAuto;

import lottoAuto.model.*;
import lottoAuto.view.InputView;
import lottoAuto.view.ResultView;

import java.util.Map;

public class LottoAutoApplication {

    public static void main(String[] args) {
        ResultView resultView = new ResultView();
        InputView inputView = new InputView();

        int price = inputView.inputPrice();
        int amount = resultView.showAmount(price);

        LottoAuto lottoAuto = new LottoAuto();
        Lottos userLottos = lottoAuto.inputUserLottoNumber(amount);
        resultView.showUserLotto(userLottos);

        String winningLottoString = inputView.inputWinningNumber();
        Lotto winningLotto = lottoAuto.inputWinningNumber(winningLottoString);
        int bonusBall = inputView.inputBonusBall();

        LottoStatistic lottoStatistic = new LottoStatistic(userLottos,winningLotto,bonusBall);
        LottoResults lottoResults = lottoStatistic.getStatistic();

        Map<Rank,Long> resultMap = resultView.showWinningStatistic(lottoResults);
        double revenue = lottoStatistic.getRevenue(price,resultMap);
        resultView.showRevenue(revenue);
    }
}