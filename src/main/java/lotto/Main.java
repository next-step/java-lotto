package lotto;

import lotto.domain.Lotto;

import static lotto.view.InputView.*;
import static lotto.view.ResultView.*;

public class Main {

    public static void main(String[] args) {

        LottoSimulator lottoSimulator = new LottoSimulator();
        RateOfReturnCalculator rateOfReturnCalculator = new RateOfReturnCalculator();

        int money = inputMoney();
        lottoSimulator.buyingLotto(money);

        printLottoCount(lottoSimulator.getLottoCount());
        printLottos(lottoSimulator.getLottos());

        int[] lastWeekLottoNumbers = inputLastWeekLottoNumbers();
        Lotto lastWeekWinningLotto = Lotto.of(lastWeekLottoNumbers);


        int[] statistics = lottoSimulator.calculateStatistics(lastWeekWinningLotto);

        double rateOfReturn = rateOfReturnCalculator.calculateYield(statistics, money);

        printStatistics(statistics, rateOfReturn);
    }
}
