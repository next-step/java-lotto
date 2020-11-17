package study.lotto.dispenser;

import study.lotto.core.Lotto;
import study.lotto.core.LottoRank;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Lottos implements Iterable<Lotto> {

    private List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    @Override
    public Iterator iterator() {
        return lottos.iterator();
    }

    public int getTotalCount() {
        return lottos.size();
    }

    public int getTotalPurchaseAmount() {
        return this.getTotalCount() * Lotto.PRICE_PER_LOTTO;
    }

}
