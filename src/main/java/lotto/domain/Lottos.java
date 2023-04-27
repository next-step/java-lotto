package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Lottos {
    private static final int ZERO = 0;

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos createManualLottos(List<Lotto> lottos) {
        return new Lottos(lottos);
    }

    public Lottos createAutoLottos(Amount autoAmount) {
        List<Lotto> autoLottos = IntStream.range(ZERO, autoAmount.getAmount())
                .mapToObj(i -> Lotto.createAutoLotto())
                .collect(Collectors.toList());

        List<Lotto> wholeLottos = Stream.concat(lottos.stream(), autoLottos.stream())
                .collect(Collectors.toList());

        return new Lottos(wholeLottos);
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
