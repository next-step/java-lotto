package lotto.controller;

import lotto.domain.LottoCreater;
import lotto.domain.Lottos;

import java.util.ArrayList;

public class LottoController {

    public Lottos lottos;

    public void purchaseLotto(int purchaseAmount) {
        this.lottos = LottoCreater.issueLottos(purchaseAmount);
    }

    public int getLottoCount() {
        return this.lottos.lottos.size();
    }

    public void checkWinningNumeber(ArrayList<Integer> winningNumbers) {
        lottos.checkWinningNumbers(winningNumbers);
    }

    public Lottos getLottosResult() {
        return this.lottos;
    }

}
