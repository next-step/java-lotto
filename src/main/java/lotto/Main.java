package lotto;

import static lotto.LottoSimulator.initLottoSimulator;
import static lotto.view.InputView.inputLastWeekLottoNumbers;
import static lotto.view.InputView.inputMoney;
import static lotto.view.ResultView.*;

public class Main {

    public static void main(String[] args) {

        LottoSimulator simulator = initLottoSimulator(inputMoney());
        printLottoCount(simulator.getLottoCount());
        printLottos(simulator.getLottoList());

        printStatistics(simulator.getStatistics(inputLastWeekLottoNumbers()), simulator.getLottoCount());
    }
}
