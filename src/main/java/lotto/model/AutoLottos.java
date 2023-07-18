package lotto.model;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.model.generator.NumbersGenerator;

public final class AutoLottos extends Lottos {

    private static final int START_INCLUSIVE = 0;

    public AutoLottos(final int size, final NumbersGenerator numberGenerator) {
        super(IntStream.range(START_INCLUSIVE, size)
                .mapToObj(count -> new Lotto(numberGenerator.generate()))
                .collect(Collectors.toUnmodifiableList())
        );
    }
}
