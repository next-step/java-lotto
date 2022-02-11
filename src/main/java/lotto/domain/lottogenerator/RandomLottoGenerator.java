package lotto.domain.lottogenerator;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;

public class RandomLottoGenerator implements LottoGenerator {

    private static final int LOTTO_SIZE_BOUND = 6;
    private static final int LOTTO_MINIMUM_BOUND = 1;
    private static final int LOTTO_MAXIMUM_BOUND = 45;
    private static final List<Integer> LOTTO = IntStream.range(LOTTO_MINIMUM_BOUND,
            LOTTO_MAXIMUM_BOUND + LOTTO_MINIMUM_BOUND)
        .boxed()
        .collect(Collectors.toList());

    public RandomLottoGenerator() {
    }

    @Override
    public Lotto generateLotto() {
        Collections.shuffle(LOTTO);
        return LOTTO.subList(0, LOTTO_SIZE_BOUND)
            .stream()
            .map(LottoNumber::new)
            .collect(Collectors.collectingAndThen(Collectors.toList(), Lotto::new));
    }
}
