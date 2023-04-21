package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottos {
    public static final int ZERO = 0;

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

    public Winners findStatistics(Lotto winningLotto) {
        Winners winners = new Winners();
        lottos.stream()
                .mapToInt(lotto -> lotto.findMatchingBall(winningLotto))
                .forEach(winners::addWinner);

        return winners;
    }
}
