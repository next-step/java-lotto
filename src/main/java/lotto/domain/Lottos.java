package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lottos {

    private final List<Lotto> lottos;

    private Lottos(Lotto... lottos) {
        this(Arrays.asList(lottos));
    }

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos as(Lotto... lottos) {
        return new Lottos(lottos);
    }

    public int getPaidMoney() {
        return lottos.size() * Lotto.PRICE;
    }

    public List<RankedLotto> checkRanking(WinningNumber winningNumber) {
        return lottos.stream()
                .map(it -> new RankedLotto(LottoRanking.valueOf(it, winningNumber), it))
                .collect(Collectors.toList());
    }
}
