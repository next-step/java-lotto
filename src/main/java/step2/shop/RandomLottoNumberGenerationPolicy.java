package step2.shop;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static step2.lotto.LottoConstant.LOTTO_NUMBER_LENGTH;
import static step2.lotto.LottoConstant.LOTTO_NUMBER_LOWER_BOUND;
import static step2.lotto.LottoConstant.LOTTO_NUMBER_UPPER_BOUND;

class RandomLottoNumberGenerationPolicy implements LottoNumberGenerationPolicy {
    private final ThreadLocalRandom random = ThreadLocalRandom.current();

    RandomLottoNumberGenerationPolicy() {
    }

    @Override
    public List<Integer> nextSix() {
        return Stream.generate(() -> random.nextInt(LOTTO_NUMBER_LOWER_BOUND, LOTTO_NUMBER_UPPER_BOUND + 1))
                     .limit(LOTTO_NUMBER_LENGTH)
                     .collect(Collectors.toList());
    }
}
