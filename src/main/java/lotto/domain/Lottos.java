package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottos {
    private static final int ZERO = 0;

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos init(Money amount) {
        List<Lotto> lottos;
        int bound = amount.getLottoQuantity();
        lottos = IntStream.range(ZERO, bound)
                .mapToObj(i -> Lotto.createAutoLotto())
                .collect(Collectors.toList());

        return new Lottos(lottos);
    }

    public Winners findStatistics(WinningLotto winningLotto) {
        Winners winners = new Winners();
        lottos.forEach(lotto -> {
            winners.addWinner(winningLotto.matchingLotto(lotto));
        });

        return winners;
    }

    @Override
    public String toString() {
        return "" + lottos;
    }
}
