package step2.domain;

import java.util.List;
import java.util.stream.Collectors;

import static step2.domain.LottoStore.LOTTO_PRICE;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return this.lottos.stream()
                          .map(Lotto::new)
                          .collect(Collectors.toList());
    }

    public Lottos addAll(Lottos lottos) {
        List<Lotto> mergedLottos = getLottos();
        mergedLottos.addAll(lottos.lottos);
        return new Lottos(mergedLottos);
    }

    public int size() {
        return this.lottos.size();
    }

    public Money getTotalPrice() {
        return LOTTO_PRICE.multiplyMoney(size());
    }
}
