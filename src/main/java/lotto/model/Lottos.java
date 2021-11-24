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

    public Result match(List<Number> winningNumber) {
        Result result = new Result();
        purchasedLottos.stream()
                       .map(lotto -> lotto.match(winningNumber))
                       .forEach(matchedCount -> result.add(matchedCount));
        return result;
    }
}
