package study.lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PurchasedLottos {
    List<Lotto> lottos = new ArrayList<>();

    public PurchasedLottos(int purchaseCount) {

        this.lottos = IntStream.range(0,purchaseCount)
                .mapToObj(i -> Lotto.randomLotto())
                .collect(Collectors.toList());
    }

    public PurchasedLottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public PurchasedLottos() {
    }

    public List<Lotto> values() {
        return lottos;
    }

    public int count() {
        return lottos.size();
    }

    public void add(List<Lotto> values) {
        lottos.addAll(values);
    }
}
