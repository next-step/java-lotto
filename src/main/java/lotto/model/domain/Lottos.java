package lotto.model.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public final class Lottos {

    public static final int START_INCLUSIVE = 0;

    private final List<Lotto> lottos;

    private Lottos(final long size, final NumbersGenerator numberGenerator) {
        validate(size);
        this.lottos = LongStream.range(START_INCLUSIVE, size)
                .mapToObj(count -> Lotto.create(numberGenerator.generate()))
                .collect(Collectors.toUnmodifiableList());
    }

    private void validate(final long size) {
        if (size < 1) {
            throw new IllegalArgumentException("로또를 구입할 수 없습니다. 로또는 한 장에 " + Lotto.COST + "원 입니다.");
        }
    }

    public static Lottos create(final long size, final NumbersGenerator numbersGenerator) {
        return new Lottos(size, numbersGenerator);
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
