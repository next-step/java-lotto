package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.WinningNumbers;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.Arrays;

public class LottoMain {

    public static final int LOTTO_PRICE = 1000;
    public static final int LOTTO_UNIT_NUMBER = 6;

    public static void main(String[] args) {
        int money = InputView.inputMoney();
        int numberOfLotto = money / LOTTO_PRICE;
        Lottos lottos = new Lottos(numberOfLotto);
        ResultView.resultLottoNumber(numberOfLotto, lottos);

        String[] winningNumberString = InputView.inputWinningNumbers().split(", ");

        Integer[] winningNumber = new Integer[LOTTO_UNIT_NUMBER];
        for (int i = 0; i < LOTTO_UNIT_NUMBER; i++) {
            winningNumber[i] = Integer.parseInt(winningNumberString[i]);
        }
        WinningNumbers winningNumbers = new WinningNumbers(new Lotto(Arrays.asList(winningNumber)));
        lottos.findWinners(winningNumbers);
        ResultView.resultWinners(winningNumbers);
        ResultView.resultRevenue(winningNumbers, money);

    }


}
