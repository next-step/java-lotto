package io.mwkwon.lotto.domain;

import io.mwkwon.lotto.enums.Rank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class BuyLottos {
    private final List<Lotto> lottos;

    private BuyLottos(final List<Lotto> lottos) {
        this.lottos = new ArrayList<>(lottos);
    }

    public static BuyLottos create(List<Lotto> lottos) {
        return new BuyLottos(lottos);
    }

    public List<Lotto> lottos() {
        return Collections.unmodifiableList(lottos);
    }

    public BuyLottos merge(BuyLottos otherBuyLottos) {
        lottos.addAll(otherBuyLottos.lottos);
        return new BuyLottos(lottos);
    }

    public List<Rank> calcLottoRank(WinningLotto winningLotto) {
        List<Rank> ranks = new ArrayList<>();
        for (Lotto lotto : lottos) {
            long matchLottoNumberCount = winningLotto.calcMatchLottoNumberCount(lotto);
            boolean isMatchBonus = winningLotto.isContainsBonusBall(lotto);
            Rank rank = Rank.matchRank(matchLottoNumberCount, isMatchBonus);
            ranks.add(rank);
        }
        return ranks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BuyLottos buyLottos1 = (BuyLottos) o;
        return Objects.equals(lottos, buyLottos1.lottos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottos);
    }
}
