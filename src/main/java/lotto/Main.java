package lotto;

import lotto.service.LottoFactory;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Main {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController(new InputView(), new OutputView(),
                                                              new LottoFactory(new MoneyCalculator()),
                                                              new MoneyCalculator());
        lottoController.startLottoWithBonus();
    }
}
