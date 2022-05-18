package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Winners;
import lotto.view.InputView;
import lotto.view.ResultView;


public class LottoMain {
    public static final int LOTTO_PRICE = 1000;

    public static void main(String[] args) {
        int money = InputView.inputMoney();
        int numberOfLotto = money / LOTTO_PRICE;
        Lottos lottos = new Lottos(numberOfLotto);
        ResultView.resultLottoNumber(numberOfLotto, lottos);

        Winners winners = new Winners(new Lotto(InputView.inputWinningNumbers()));
        lottos.findWinners(winners);

        ResultView.resultWinners(winners);
        ResultView.resultRevenue(winners, money);

    }


}
