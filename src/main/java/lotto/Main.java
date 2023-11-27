package lotto;

import lotto.domain.Lotto;

import java.util.Map;

import static lotto.view.InputView.*;
import static lotto.view.ResultView.*;

public class Main {

    public static void main(String[] args) {


        LottoSimulator lottoSimulator = new LottoSimulator();
        int money = inputMoney();
        lottoSimulator.buyingLotto(money);

        printLottoCount(lottoSimulator.getLottoCount());
        printLottos(lottoSimulator.getLottos());

        int[] lastWeekLottoNumbers = inputLastWeekLottoNumbers();
        Lotto lastWeekWinningLotto = Lotto.of(lastWeekLottoNumbers);


        Map<RewardPrice, Integer> statistics = lottoSimulator.calculateStatistics(lastWeekWinningLotto);

        RateOfReturnCalculator rateOfReturnCalculator = new RateOfReturnCalculator();
        double rateOfReturn = rateOfReturnCalculator.calculateYield(statistics, money);

        printStatistics(statistics, rateOfReturn);
    }
}
