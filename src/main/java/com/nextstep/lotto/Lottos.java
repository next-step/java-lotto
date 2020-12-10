package com.nextstep.lotto;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private List<Lotto> lottos = new ArrayList<>();

    public void add(Lotto lotto) {
        lottos.add(lotto);
    }

    public int size() {
        return lottos.size();
    }

    public LottoStatistics getStatistics(List<Integer> winningNumbers) {
        LottoStatistics lottoStatistics = new LottoStatistics();
        for (Lotto lotto : lottos) {
            lottoStatistics.addCount(lotto.getWinning(winningNumbers));
        }
        return lottoStatistics;
    }
}
