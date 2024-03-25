package controller;

import domain.Lotto;
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

    private Lotto winNumbers() {
        return lottoMachine.pull();
    }

    public void run(int cnt) {
        totalLotto(cnt);
    }

    public void resultReturn() {
        Lotto winLotto = winNumbers();
        for (Lotto lotto : myLotto) {

        }
    }

}
