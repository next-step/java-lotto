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
        List<Lotto> autoLottos = makeAutoLottos(autoAmount);
        List<Lotto> wholeLottos = concatLottos(autoLottos);

        return new Lottos(wholeLottos);
    }

    private List<Lotto> makeAutoLottos(Amount autoAmount) {
        return IntStream.range(ZERO, autoAmount.getAmount())
                .mapToObj(i -> Lotto.createAutoLotto())
                .collect(Collectors.toList());
    }

    private List<Lotto> concatLottos(List<Lotto> autoLottos) {
        return Stream.concat(lottos.stream(), autoLottos.stream())
                .collect(Collectors.toList());
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
