package lottoAuto;

import lottoAuto.model.*;
import lottoAuto.view.InputView;
import lottoAuto.view.ResultView;

import java.util.Map;

public class LottoAutoApplication {

    public static void main(String[] args) {
        int price = InputView.inputPrice();
        int amount = ResultView.showAmount(price);

        LottoAuto lottoAuto = new LottoAuto();
        Lottos userLottos = lottoAuto.inputUserLottoNumber(amount);
        ResultView.showUserLotto(userLottos);

        String winningLottoString = InputView.inputWinningNumber();
        Lotto winningLotto = lottoAuto.inputWinningNumber(winningLottoString);
        int bonusBall = InputView.inputBonusBall();

        LottoStatistic lottoStatistic = new LottoStatistic(userLottos,winningLotto,bonusBall);
        LottoResults lottoResults = lottoStatistic.getStatistic();

        Map<Rank,Long> resultMap = ResultView.showWinningStatistic(lottoResults);
        double revenue = lottoStatistic.getRevenue(price,resultMap);
        ResultView.showRevenue(revenue);
    }
}