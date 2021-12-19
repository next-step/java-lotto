package lotto.controller;

import lotto.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.math.BigDecimal;
import java.util.Map;

public class Main {

    static InputView inputView = new InputView();
    static OutputView outputView = new OutputView();

    public static void main(String[] args) {
        LottoMachine lottoMachine = new LottoMachine();

        int moneyForLotto = inputView.showMessageAndGetMoneyInput();
        Lottos lottos = lottoMachine.buyLottos(moneyForLotto);

        outputView.showHowManyLottosBoughtWithMoney(lottos);
        outputView.showLottos(lottos);

        WinnerLotto winnerLotto = getWinnerLotto();

        Map<Rank, Integer> matchCounts = lottoMachine.calculateMatchCount(lottos, winnerLotto);
        outputView.showMatchCount(matchCounts);

        BigDecimal profit = lottoMachine.calculateProfit(lottos, winnerLotto);
        outputView.showLottoProfit(profit);
    }

    private static WinnerLotto getWinnerLotto() {
        String lottoWinNumbers = inputView.showMessageAndGetLastWeekLottoWinNumbers();
        int bonusNumber = inputView.showMessageAndGetBonusNumber();

        return new WinnerLotto(lottoWinNumbers, bonusNumber);
    }

}
