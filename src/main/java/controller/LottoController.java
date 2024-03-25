package controller;

import domain.LottoMachine;
import domain.MyLotto;

public class LottoController {

    private final LottoMachine lottoMachine = new LottoMachine();
    private final MyLotto myLotto = new MyLotto();
    private void totalLotto(int count) {
        for (int i = 0; i < count; i++) {
            myLotto.add(lottoMachine.pull());
        }
    }

    public void
}
