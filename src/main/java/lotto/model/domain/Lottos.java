package lotto.model.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public final class Lottos {

    public static final int START_INCLUSIVE = 0;
    public static final NumbersGenerator NUMBERS_GENERATOR = RandomNumbersGenerator.getInstance();

    private final List<Lotto> lottos;

    private Lottos(final long size, final NumbersGenerator numberGenerator) {
        validate(size);
        this.lottos = LongStream.range(START_INCLUSIVE, size)
                .mapToObj(count -> Lotto.create(numberGenerator.generate()))
                .collect(Collectors.toUnmodifiableList());
    }

    public Lottos(final List<List<Integer>> manualLottos, final long size) {
        this.lottos = Stream.concat(manualLottos.stream().map(Lotto::create),
                        LongStream.range(START_INCLUSIVE, size).mapToObj(count -> Lotto.create(NUMBERS_GENERATOR.generate())))
                .collect(Collectors.toUnmodifiableList());
    }

    public static Lottos create(final long size, final NumbersGenerator numbersGenerator) {
        return new Lottos(size, numbersGenerator);
    }

    public static Lottos create(final List<List<Integer>> manualLottos, final long size) {
        return new Lottos(manualLottos, size);
    }

    private void validate(final long size) {
        if (size < 1) {
            throw new IllegalArgumentException("로또를 구입할 수 없습니다. 로또는 한 장에 " + Lotto.COST + "원 입니다.");
        }
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
