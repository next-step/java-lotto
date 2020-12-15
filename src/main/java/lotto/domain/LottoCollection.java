package lotto.domain;

import java.util.*;

public class LottoCollection {
    private final List<Lotto> lottoList = new ArrayList<>();

    public LottoCollection(int lottoCount, NumberListGenerator numberListGenerator) {
        for (int i = 0; i < lottoCount; i++) {
            Set<Integer> generate = numberListGenerator.generate();
            lottoList.add(new Lotto(generate));
        }
    }

    public LottoResult getLottoResult(Lotto winnerLotto) {
        return new LottoResult(lottoList, winnerLotto);
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }
}
