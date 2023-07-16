package lotto.model.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public final class Lottos {

    public static final int START_INCLUSIVE = 0;
    public static final NumbersGenerator NUMBERS_GENERATOR = RandomNumbersGenerator.getInstance();

    private final List<Lotto> lottos;

    public Lottos(final List<List<Integer>> manualLottos, final long automaticSize) {
        this.lottos = Stream.concat(
                        manualLottosStream(manualLottos),
                        automaticLottosStream(automaticSize))
                .collect(Collectors.toUnmodifiableList());
    }

    public static Lottos create(final List<List<Integer>> manualLottos, final long automaticSize) {
        return new Lottos(manualLottos, automaticSize);
    }

    private static Stream<Lotto> manualLottosStream(final List<List<Integer>> manualLottos) {
        return manualLottos.stream()
                .map(Lotto::create);
    }

    private static Stream<Lotto> automaticLottosStream(final long size) {
        return LongStream.range(START_INCLUSIVE, size)
                .mapToObj(count -> Lotto.create(NUMBERS_GENERATOR.generate()));
    }

    public List<Rank> matchWinningNumbers(final WinningLotto winningLotto) {
        return lottos.stream()
                .map(winningLotto::checkRank)
                .collect(Collectors.toUnmodifiableList());
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
