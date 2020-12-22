package com.monds.nextstep.lotto.domain;

import java.util.*;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(int size) {
        lottos = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            lottos.add(LottoGenerator.shuffleAndGet());
        }
    }

    public int size() {
        return lottos.size();
    }

    public List<Lotto> getAll() {
        return Collections.unmodifiableList(lottos);
    }

    public LottoResult getLottoResult(WinningLotto winningLotto) {
        Map<LottoRanking, Integer> countByRanking = new HashMap<>();
        for (Lotto lotto : lottos) {
            LottoRanking ranking = winningLotto.matching(lotto);
            countByRanking.put(ranking, countByRanking.getOrDefault(ranking, 0) + 1);
        }
        return new LottoResult(lottos.size(), countByRanking);
    }
}
