package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottos {
    public static final int ZERO = 0;
    public static final int ADD_COUNT = 1;

    private final List<Lotto> lottos;

    Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos initLottos(Money amount) {
        List<Lotto> lottos = IntStream.range(ZERO, amount.getLottoQuantity())
                .mapToObj(i -> Lotto.initLotto())
                .collect(Collectors.toList());

        return new Lottos(lottos);
    }

    public Lotto getLotto(int index) {
        return lottos.get(index);
    }

    public int getLottoQuantity() {
        return lottos.size();
    }

    public Map<Integer, Integer> findStatistics(Lotto winningLotto) {
        return lottos.stream()
                .mapToInt(lotto -> lotto.findSameNumber(winningLotto))
                .boxed()
                .collect(Collectors.toMap(Function.identity(), v -> ADD_COUNT, Integer::sum));
    }
}
