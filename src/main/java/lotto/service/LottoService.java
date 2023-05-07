package lotto.service;

import lotto.domain.*;

import java.util.List;

public class LottoService {

    public MyLottos buyAutoLottos(Purchase purchase) {
        return MyLottos.autoGenerate(purchase);
    }

    public WinLotto makeWinLotto(List<Integer> winLottoInfoNumbers) {
        Numbers numbers = new Numbers(winLottoInfoNumbers);
        return new WinLotto(numbers);
    }

    public void checkWin(MyLottos lottos, WinLotto winLotto) {
        lottos.checkWin(winLotto);
    }

}
