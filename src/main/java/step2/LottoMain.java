package step2;

import step2.domian.Lotto;
import step2.domian.QrMachine;
import step2.view.InputView;
import step2.view.ResultView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static step2.domian.Calculator.calculatePercentage;
import static step2.domian.Calculator.calculateRevenue;
import static step2.domian.LottoMachine.autoLottoLists;

public class LottoMain {
    public static final int LOTTO_PRICE = 1000;

    public static void main(String[] args) {
        int lottoNum = InputView.buyLotto() / LOTTO_PRICE;
        ResultView.printLottoCount(lottoNum);

        List<Lotto> autoLottoLists = autoLottoLists(lottoNum);
        ResultView.printLottoNum(autoLottoLists);

        Lotto lastWinner = new Lotto(InputView.getLastWinner());
        List<Integer> results = QrMachine.compareWithLastLotto(autoLottoLists, lastWinner);
        ResultView.printDrawResult(results);

        int revenue = calculateRevenue(results);
        ResultView.printPercentage(calculatePercentage(lottoNum * LOTTO_PRICE, revenue));
    }
}
