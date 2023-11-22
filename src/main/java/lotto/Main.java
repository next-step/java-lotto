package lotto;

import java.util.List;

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

        List<Integer> lastWeekLottoNumbers = inputLastWeekLottoNumbers();

        int[] statistics = lottoSimulator.calculateStatistics(lastWeekLottoNumbers);

        double rateOfReturn = rateOfReturnCalculator.calculateYield(statistics, money);

        printStatistics(statistics, rateOfReturn);
    }
}
