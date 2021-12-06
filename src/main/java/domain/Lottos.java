package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static domain.Lotto.PRICE;

public class Lottos {
    private static final int STARTING_INDEX_LOTTOS = 0;

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Stream<Lotto> stream() {
        return lottos.stream();
    }

    public int investment() {
        return lottos.size() * PRICE;
    }

    public Prizes prizes(Lotto winningLotto, LottoNumber lottoNumber) {
        Prizes prizes = new Prizes();
        lottos.forEach(lotto -> {
            Optional<PrizeCondition> prizeCondition = lotto.prizeCondition(winningLotto, lottoNumber);
            prizeCondition.ifPresent(prizes::savePrize);
        });

        return prizes;
    }

    public static Lottos of(int totalNumberOfLottos) {
        List<Lotto> lottos = new ArrayList<>();

        IntStream.range(STARTING_INDEX_LOTTOS, totalNumberOfLottos)
                .forEach(i -> lottos.add(Lotto.of()));

        return new Lottos(lottos);
    }
}
