package io.mwkwon.lotto.domain;

import io.mwkwon.lotto.enums.Rank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class LottoStore {

    private final List<Lotto> lottos;

    public LottoStore() {
        this.lottos = new ArrayList<>();
    }

    public LottoStore(List<Lotto> lottos) {
        this.lottos = new ArrayList<>(lottos);
    }

    public void buyAutoLottos(LottoPayment lottoPayment) {
        int lottoBuyQuantity = lottoPayment.calcLottoBuyQuantity();
        for (int i = 0; i < lottoBuyQuantity; i++) {
            this.lottos.add(Lotto.createAutoLotto());
        }
    }

    public List<Lotto> lottos() {
        return Collections.unmodifiableList(this.lottos);
    }

    public List<Rank> calcLottosRank(Lotto winningLotto) {
        List<Rank> ranks = new ArrayList<>();
        for (Lotto lotto : lottos) {
            Rank rank = lotto.calcLottoRank(winningLotto);
            ranks.add(rank);
        }
        return ranks;
    }
}
