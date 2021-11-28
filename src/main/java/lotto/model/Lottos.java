package lotto.model;

import java.util.Collections;
import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

    public Result makeResult(Lotto target, Number bonusNumber) {
        Result result = new Result();
        lottos.stream()
              .map(lotto -> lotto.match(target, bonusNumber))
              .forEach(matchedCount -> result.add(matchedCount));
        return result;
    }
}
