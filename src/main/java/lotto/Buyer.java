package lotto;


import lotto.Controller.LottoController;
import lotto.Domain.*;
import lotto.View.InputView;

import java.util.ArrayList;
import java.util.List;

public class Buyer {

    private Buyer() {
    }

    public static Buyer of() {
        return new Buyer();
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
