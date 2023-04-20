package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottos {
    public static final int ZERO = 0;

    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos initLottos(int quantity) {
        List<Lotto> lottos = IntStream.range(ZERO, quantity)
                .mapToObj(i -> Lotto.initLotto())
                .collect(Collectors.toList());

        return new Lottos(lottos);
    }

    public int getLottoQuantity() {
        return lottos.size();
    }
}
