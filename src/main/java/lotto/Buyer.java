package lotto;


import lotto.Controller.LottoController;
import lotto.Domain.*;
import lotto.View.InputView;


public class Buyer {

    int amount;
    LottoMachine lottoMachine;

    private Buyer(int amount) {
        this.amount = amount;
        this.lottoMachine = LottoMachine.init();
    }

    public static Buyer of(int amount) {
        return new Buyer(amount);
    }

    public void perchase() {
        LottoController lottoController = new LottoController(InputView.init(), LottoMachine.init());
        int count = lottoController.payToLotto();
        Lottos lottos = lottoController.buyAutoLotto(count);
        lottoController.boughtLottoList(lottos);
        WinningLotto laskweekWinLotto = lottoController.inputLastWeekWinLotto();
        LottoResult lottoResult = lottoController.lottoResult(lottos, laskweekWinLotto);
        lottoController.printLottoResult(lottoResult);
    }
}