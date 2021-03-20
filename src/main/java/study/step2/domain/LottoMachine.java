package study.step2.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private static final int LOTTO_PRICE = 1000;

    public LottoMachine() {
    }

    public List<Lotto> purchase(int amount) {
        List<Lotto> lottos = new ArrayList<>();
        for(int i=0; i<getLottoCount(amount); i++) {
            lottos.add(LottoFactory.createLotto());
        }
        return lottos;
    }

    private int getLottoCount(int amount) {
        return amount / LOTTO_PRICE;
    }

}
