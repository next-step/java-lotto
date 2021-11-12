package lotto.step2.domain;

import lotto.step2.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LotteryStore {

    private static final int LOTTO_PRICE = 1000;

    private int totalCount;
    private List<Lotto> lottos = new ArrayList<>();

    public LotteryStore(int orderPrice) {
        totalCount = orderPrice / 1000;
        for (int i = 0; i < totalCount; i++) {
            lottos.add(new Lotto(LOTTO_PRICE));
        }
    }

    public int getTotalCount() {
        return totalCount;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
