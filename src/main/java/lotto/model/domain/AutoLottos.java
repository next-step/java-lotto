package lotto.model.domain;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class AutoLottos extends Lottos {

    public static final int START_INCLUSIVE = 0;

    public AutoLottos(final int size, final NumbersGenerator numberGenerator) {
        super(IntStream.range(START_INCLUSIVE, size)
                .mapToObj(count -> new Lotto(numberGenerator.generate()))
                .collect(Collectors.toUnmodifiableList())
        );
    }
}
