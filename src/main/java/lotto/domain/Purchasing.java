package lotto.domain;

import lotto.strategy.RandomNumberStrategy;

import java.util.ArrayList;
import java.util.List;

public class Purchasing {

    private static final int LOTTO_PRICE = 1000;
    private final List<Lotto> lottoList;

    public Purchasing(int money) {
        lottoList = new ArrayList<>();
        for (int i = 0; i < money / LOTTO_PRICE; i++) {
            lottoList.add(new Lotto(new RandomNumberStrategy()));
        }
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }

    public int getLottoCnt() {
        return lottoList.size();
    }
}
