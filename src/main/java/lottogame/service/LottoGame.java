package lottogame.service;


import lottogame.model.Lottos;

import java.util.List;

public class LottoGame {

    Lottos lottos = new Lottos();

    final static int PRICE = 1000;

    public int getBuyCount(int buyPrice) {
        return buyPrice / PRICE;
    }

    public Lottos purchaseManualLottoList(List<String> manualLottoList) {
        return lottos.purchaseManualLottoList(manualLottoList);
    }
}
