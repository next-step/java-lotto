package com.monds.nextstep.lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos() {
        lottos = new ArrayList<>();
    }

    public void addAuto(int size) {
        for (int i = 0; i < size; i++) {
            add(LottoGenerator.shuffleAndGet());
        }
    }

    public int size() {
        return lottos.size();
    }

    public void forEachLotto(Consumer<Lotto> lottoConsumer) {
        for (Lotto lotto : lottos) {
            lottoConsumer.accept(lotto);
        }
    }

    public void add(Lotto lotto) {
        lottos.add(lotto);
    }

    public LottoResult getLottoResult(WinningLotto winningLotto) {
        LottoResult result = new LottoResult(lottos.size());
        for (Lotto lotto : lottos) {
            LottoRanking ranking = winningLotto.matching(lotto);
            result.addRanking(ranking);
        }
        return result;
    }
}
