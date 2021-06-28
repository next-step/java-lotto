package lottogame.service;


import lottogame.model.Lotto;
import lottogame.model.LottoMachine;
import lottogame.model.Lottos;

import java.util.List;

public class LottoGame {

    Lottos lottos = new Lottos();

    final static int PRICE = 1000;

    public int getBuyCount(int buyPrice) {
        return buyPrice / PRICE;
    }

    public void purchaseManualLottoList(List<String> manualLottoList) {
        lottos.purchaseManualLottoList(manualLottoList);
    }

    public void purchaseAutoLottoList(int autoBuyCount) {
         lottos.purchaseAutoLottoList(autoBuyCount);
    }

    public Lottos getLottos() {
        return lottos;
    }

    public Lotto getWinningLotto(String inputWinningLottoNumber) {
        LottoMachine lottoMachine = new LottoMachine();
        return lottoMachine.generateLotto(inputWinningLottoNumber);
    }
}
