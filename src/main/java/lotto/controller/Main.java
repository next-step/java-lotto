package lotto.controller;

import lotto.LottoResult;
import lotto.Lottos;
import lotto.WinnerLotto;
import lotto.view.InputView;

public class Main {

    static InputView inputView = new InputView();
    static LottoController lottoController = new LottoController();

    public static void main(String[] args) {
        int moneyForLotto = inputView.showMessageAndGetMoneyInput();
        Lottos boughtLottos = lottoController.buyLottos(moneyForLotto);

        String lottoWinNumbers = inputView.showMessageAndGetLastWeekLottoWinNumbers();
        int bonusNumber = inputView.showMessageAndGetBonusNumber();
        WinnerLotto winnerLotto = lottoController.getWinnerLotto(lottoWinNumbers, bonusNumber);

        LottoResult lottoResult = lottoController.calculateLottoResult(boughtLottos, winnerLotto);
        lottoController.calculateTotalProfit(lottoResult);
    }

}
