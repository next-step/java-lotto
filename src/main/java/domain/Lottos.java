package domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottos {
    private final List<Lotto> value;

    private Lottos(List<Lotto> value) {
        this.value = value;
    }

    public static Lottos generate(int count, LottoNumberGenerator generator) {
        List<Lotto> lottos = IntStream.range(0, count)
                .mapToObj(i -> LottoMachine.create(generator.generate()))
                .collect(Collectors.toList());
        return new Lottos(lottos);
    }

    public List<Lotto> getValue() {
        return value;
    }

    public List<Rank> match(WinningNumber winningNumber) {
        return value.stream()
                .map(lotto -> RankDecider.decide(lotto, winningNumber))
                .collect(Collectors.toList());
    }
}
