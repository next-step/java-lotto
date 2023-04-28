package lotto.domain;

import lotto.domain.strategy.LottoStrategy;
import lotto.domain.winning.WinningBall;
import lotto.domain.winning.WinningStat;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Lottos(int unitCount, LottoStrategy lottoStrategy) {
        final List<Lotto> lottoList = new ArrayList<>();

        for (int i = 0; i < unitCount; i++) {
            lottoList.add(new Lotto(lottoStrategy));
        }

        this.lottos = lottoList;
    }

    public static Lottos manualLottos(List<String> manualNumbers) {
        final List<Lotto> lottos = new ArrayList<>();

        for (String manualNumber : manualNumbers) {
            lottos.add(Lotto.manualLotto(manualNumber));
        }

        return new Lottos(lottos);
    }

    public void rating(WinningStat winningStat, WinningBall winningBall) {
        for (Lotto lotto : this.lottos) {
            winningStat.judgeWinning(lotto, winningBall);
        }
    }

    public List<List<Integer>> lottoNumberList() {
        final List<List<Integer>> lottoNumberList = new ArrayList<>();

        for (Lotto lotto : this.lottos) {
            lottoNumberList.add(lotto.getIntegerLottoNumbers());
        }

        return lottoNumberList;
    }

    public int size() {
        return this.lottos.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lottos lottos1 = (Lottos) o;
        return Objects.equals(lottos, lottos1.lottos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottos);
    }
}
