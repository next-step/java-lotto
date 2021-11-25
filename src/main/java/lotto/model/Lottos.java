package lotto.model;

import java.util.Collections;
import java.util.List;

public class Lottos {

    private final List<Lotto> purchasedLottos;

    public Lottos(List<Lotto> purchasedLottos) {
        this.purchasedLottos = purchasedLottos;
    }

    public List<Lotto> getPurchasedLottos() {
        return Collections.unmodifiableList(purchasedLottos);
    }

    public Result makeResult(Lotto target) {
        Result result = new Result();
        purchasedLottos.stream()
                       .map(lotto -> lotto.match(target))
                       .forEach(matchedCount -> result.add(matchedCount));
        return result;
    }
}
