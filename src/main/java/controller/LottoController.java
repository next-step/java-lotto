package controller;

import domain.Lotto;
import domain.LottoMachine;
import domain.MyLotto;
import domain.WinStatus;

import java.util.List;

public class LottoController {

    private static final LottoMachine lottoMachine = new LottoMachine();
    private static MyLotto myLotto = new MyLotto();
    private final WinStatus winStatus = new WinStatus();

    public void totalLotto(int count) {
        for (int i = 0; i < count; i++) {
            List<Integer> nowLotto = lottoMachine.pull();
            System.out.println(nowLotto);
            myLotto.add(nowLotto);
        }
    }

    public WinStatus resultReturn(Lotto winLotto) {

        for (Lotto currentLotto  : myLotto.getLotto()) {
            int price = currentLotto .numberCheck(winLotto);
            if (price >= 3) {
                winStatus.correct(price - 3);
            }
        }
        return winStatus;
    }

}
