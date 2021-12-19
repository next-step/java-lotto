package lotto.controller;

import lotto.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.math.BigDecimal;
import java.util.Map;

public class Main {

    static InputView inputView = new InputView();
    static OutputView outputView = new OutputView();
    static LottoMachine lottoMachine = new LottoMachine();

    public static void main(String[] args) {
        Lottos lottos = buyLottos();
        showLottoInfo(lottos);

        WinnerLotto winnerLotto = getWinnerLotto();
        showWinnerMatchCount(lottos, winnerLotto);
        showLottoTotalProfit(lottos, winnerLotto);
    }

    private static Lottos buyLottos() {
        int moneyForLotto = inputView.showMessageAndGetMoneyInput();
        return lottoMachine.buyLottos(moneyForLotto);
    }

    private static void showLottoInfo(Lottos lottos) {
        outputView.showHowManyLottosBoughtWithMoney(lottos);
        outputView.showLottos(lottos);
    }

    private static WinnerLotto getWinnerLotto() {
        String lottoWinNumbers = inputView.showMessageAndGetLastWeekLottoWinNumbers();
        int bonusNumber = inputView.showMessageAndGetBonusNumber();

        return new WinnerLotto(lottoWinNumbers, bonusNumber);
    }

    private static void showWinnerMatchCount(Lottos lottos, WinnerLotto winnerLotto) {
        Map<Rank, Integer> matchCounts = lottoMachine.calculateMatchCount(lottos, winnerLotto);
        outputView.showMatchCount(matchCounts);
    }

    private static void showLottoTotalProfit(Lottos lottos, WinnerLotto winnerLotto) {
        BigDecimal profit = lottoMachine.calculateProfit(lottos, winnerLotto);
        outputView.showLottoProfit(profit);
    }

}
