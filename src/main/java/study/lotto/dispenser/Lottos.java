package study.lotto.dispenser;

import study.lotto.core.Lotto;
import study.lotto.core.LottoRank;

import javax.swing.text.html.Option;
import java.util.*;
import java.util.stream.Collectors;

public class Lottos implements Iterable<Lotto> {

    private List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = Optional.ofNullable(lottos)
                .orElse(new ArrayList<>());
    }

    public static Lottos mergeLottos(Lottos a, Lottos b) {
        List<Lotto> mergedLottos = new ArrayList<>();
        mergedLottos.addAll(a.lottos);
        mergedLottos.addAll(b.lottos);
        return new Lottos(mergedLottos);
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
