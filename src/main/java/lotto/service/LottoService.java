package lotto.service;

import lotto.domain.*;

import java.util.List;

public class LottoService {

    public MyLottoGame buyAutoLottos(MyPurchase myPurchase) {
        return MyLottoGame.autoGenerate(myPurchase);
    }

    public WinLotto makeWinLotto(List<Integer> winNumbers, Integer winBonusNumber) {
        Numbers numbers = new Numbers(winNumbers);
        return new WinLotto(numbers, winBonusNumber);
    }

    public MyResult checkWin(MyLottoGame myLottoGame, WinLotto winLotto) {
        return myLottoGame.checkWin(winLotto);
    }

}
