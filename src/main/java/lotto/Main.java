package lotto;

import java.util.List;

import static lotto.LottoSimulator.initLottoSimulator;
import static lotto.view.InputView.inputLastWeekLottoNumbers;
import static lotto.view.InputView.inputMoney;
import static lotto.view.ResultView.*;

public class Main {

    public static void main(String[] args) {

        int money = inputMoney();
        LottoSimulator simulator = initLottoSimulator(money);

        printLottoCount(simulator.getLottoCount());
        printLottos(simulator.getLottos());

        List<Integer> lastWeekLottoNumbers = inputLastWeekLottoNumbers();

        printStatistics(simulator.getStatistics(lastWeekLottoNumbers), simulator.getLottoCount());
    }
}
