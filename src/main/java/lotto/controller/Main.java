package lotto.controller;

import lotto.Lotto;
import lotto.LottoMachine;
import lotto.Lottos;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.math.BigDecimal;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LottoMachine lottoMachine = new LottoMachine();

        int moneyForLotto = inputView.showMessageAndGetMoneyInput();
        Lottos lottos = lottoMachine.buyLottos(moneyForLotto);

        outputView.showHowManyLottosBoughtWithMoney(lottos);
        outputView.showLottos(lottos);

        String lottoWinNumbers = inputView.showMessageAndGetLastWeekLottoWinNumbers();
        Lotto winnerLotto = new Lotto(lottoWinNumbers);

        Map<Integer, Integer> matchCounts = lottoMachine.calculateMatchCount(lottos, winnerLotto);
        outputView.showMatchCount(matchCounts);

        BigDecimal profit = lottoMachine.calculateProfit(lottos, winnerLotto);
        outputView.showLottoProfit(profit);
    }

}
