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
        UserLottos userLottos = lottoAuto.inputUserLottoNumber(amount);
        ResultView.showUserLotto(userLottos);

        String winningLottoString = InputView.inputWinningNumber();
        Lotto winningLotto = lottoAuto.inputWinningNumber(winningLottoString);
        int bonusBall = InputView.inputBonusBall();

        LottoStatistic lottoStatistic = new LottoStatistic(userLottos,winningLotto,bonusBall);
        Map<Rank,Long> resultMap = lottoStatistic.getStatistic();

        ResultView.showWinningStatistic(resultMap);
        double revenue = lottoStatistic.getRevenue(price,resultMap);
        ResultView.showRevenue(revenue);
    }
}