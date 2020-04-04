package lotto;


import lotto.Controller.LottoController;
import lotto.Domain.Lotto;
import lotto.Domain.LottoMachine;
import lotto.Domain.Lottos;
import lotto.View.InputView;

import java.util.ArrayList;
import java.util.List;

public class Buyer {

    int amount;
    LottoMachine lottoMachine;

    private Buyer(int amount) {
        this.amount = amount;
        lottoMachine = LottoMachine.init();
    }

    public static Buyer of(int amount) {
        return new Buyer(amount);
    }

    public void perchase() {
        LottoController lottoController = new LottoController(InputView.init(), LottoMachine.init());
        int count = lottoController.payToLotto();
        Lottos lottos = lottoController.buyAutoLotto(count);
        List<Integer> laskweekWinLotto = lottoController.inputLastWeekWinLotto();
//        lottoController.LottoResult(lottos, laskweekWinLotto);
    }
}
