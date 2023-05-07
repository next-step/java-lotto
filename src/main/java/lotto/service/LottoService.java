package lotto.service;

import lotto.domain.*;

import java.util.List;

public class LottoService {

    public MyLottos buyAutoLottos(MyPurchase myPurchase) {
        return MyLottos.autoGenerate(myPurchase);
    }

    public WinLotto makeWinLotto(List<Integer> winNumbers, Integer winBonusNumber) {
        Numbers numbers = new Numbers(winNumbers);
        return new WinLotto(numbers, winBonusNumber);
    }

    public void checkWin(MyLottos lottos, WinLotto winLotto) {
        lottos.checkWin(winLotto);
    }

}
