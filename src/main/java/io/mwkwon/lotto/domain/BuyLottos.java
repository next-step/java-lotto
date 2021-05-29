package io.mwkwon.lotto.domain;

import io.mwkwon.lotto.enums.Rank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class BuyLottos {
    private final List<Lotto> lottos;

    public BuyLottos(final List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static BuyLottos create(List<Lotto> manualLottos, List<Lotto> autoLottos) {
        manualLottos.addAll(autoLottos);
        return new BuyLottos(manualLottos);
    }

    public List<Lotto> lottos() {
        return Collections.unmodifiableList(lottos);
    }

    public List<Rank> calcLottoRank(Lotto winningLotto, LottoNumber bonusLottoNumber) {
        List<Rank> ranks = new ArrayList<>();
        for (Lotto lotto : lottos) {
            long matchLottoNumberCount = lotto.calcMatchLottoNumberCount(winningLotto);
            Rank rank = Rank.matchRank(matchLottoNumberCount, lotto.isContains(bonusLottoNumber));
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
