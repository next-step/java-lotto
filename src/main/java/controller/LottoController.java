package controller;

import domain.Lotto;
import domain.LottoMachine;
import domain.MyLotto;
import domain.WinStatus;

public class LottoController {

    private final LottoMachine lottoMachine = new LottoMachine();
    private final MyLotto myLotto = new MyLotto();
    private final WinStatus winStatus = new WinStatus();
    private void totalLotto(int count) {
        for (int i = 0; i < count; i++) {
            myLotto.add(lottoMachine.pull());
        }
    }


    public MyLotto getMyLotto() {
        return myLotto;
    }

    public void run(int cnt) {
        totalLotto(cnt);
    }

    public WinStatus resultReturn(Lotto winLotto) {
        for (Lotto lotto : MyLotto.getLotto()) {
            int price = lotto.numberCheck(winLotto);
            if (price >= 3) {
                winStatus.correct(price);
            }
        }
        return winStatus;
    }

}
