package lotto.domain;

import lotto.domain.strategy.LottoStrategy;

import java.util.ArrayList;
import java.util.List;

public class LottoList {
    private final List<Lotto> lottoList;

    public LottoList(int unitCount, LottoStrategy lottoStrategy) {
        final List<Lotto> lottoList = new ArrayList<>();

        for (int i = 0; i < unitCount; i++) {
            lottoList.add(new Lotto(lottoStrategy));
        }

        this.lottoList = lottoList;
    }
}
