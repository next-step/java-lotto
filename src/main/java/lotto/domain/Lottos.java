package lotto.domain;

import lotto.domain.strategy.LottoStrategy;
import lotto.domain.winning.WinningBall;
import lotto.domain.winning.WinningStat;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(int unitCount, LottoStrategy lottoStrategy) {
        final List<Lotto> lottoList = new ArrayList<>();

        for (int i = 0; i < unitCount; i++) {
            lottoList.add(new Lotto(lottoStrategy));
        }

        this.lottos = lottoList;
    }

    public WinningStat rating(WinningBall winningBall) {
        final WinningStat winningStat = new WinningStat();

        for (Lotto lotto : this.lottos) {
            winningStat.judgeWinning(lotto, winningBall);
        }

        return winningStat;
    }

    public List<List<Integer>> lottoNumberList() {
        final List<List<Integer>> lottoNumberList = new ArrayList<>();

        for (Lotto lotto : this.lottos) {
            lottoNumberList.add(lotto.getIntegerLottoNumbers());
        }

        return lottoNumberList;
    }
}
