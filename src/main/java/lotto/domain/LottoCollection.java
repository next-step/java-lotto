package lotto.domain;

import java.util.*;

public class LottoCollection {
    private static final int ONE_LOTTO_COST = 1000;

    private final List<Lotto> lottoList = new ArrayList<>();
    private final int buyAmount;

    public LottoCollection(int buyAmount, NumberListGenerator numberListGenerator) {
        this.buyAmount = buyAmount;
        int lottoCount = convertLottoCount(buyAmount);
        for (int i = 0; i < lottoCount; i++) {
            Set<Integer> generate = numberListGenerator.generate();
            lottoList.add(new Lotto(generate));
        }
    }

    public LottoResult getLottoResult(Lotto winnerLotto) {
        return new LottoResult(lottoList, winnerLotto, buyAmount);
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }

    private static int convertLottoCount(int buyAmount) {
        return buyAmount / ONE_LOTTO_COST;
    }
}
