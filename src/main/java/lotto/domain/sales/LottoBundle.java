package lotto.domain.sales;

import lotto.domain.number.Lotto;
import lotto.domain.prize.WinningPrize;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoBundle {

    private final List<Lotto> lottos;

    private LottoBundle(List<Lotto> lottos) {
        this.lottos = Collections.unmodifiableList(lottos);
    }

    public static LottoBundle of(int quantity) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            lottos.add(Lotto.create());
        }
        return new LottoBundle(lottos);
    }

    public static LottoBundle of(List<Lotto> lottos) {
        return new LottoBundle(lottos);
    }

    public Lotto lotto(int index) {
        return lottos.get(index);
    }

    public int count() {
        return lottos.size();
    }

    public WinningPrize winPrize(Lotto winningLotto) {
        WinningPrize winningPrize = new WinningPrize();
        for (Lotto lotto : lottos) {
            winningPrize.record(winningLotto.match(lotto));
        }
        return winningPrize;
    }

    @Override
    public String toString() {
        return lottos.toString();
    }
}
