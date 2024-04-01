package lotto.domain.publish;

import static lotto.domain.Lotto.LOTTO_NUMBERS_SIZE;
import static lotto.domain.LottoNumber.MAXIMUM_LOTTO_NUMBER;
import static lotto.domain.LottoNumber.MINIMUM_LOTTO_NUMBER;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lotto.domain.LottoNumber;

public class RandomLottoNumbersPicker implements LottoNumbersPicker {

    private static final ThreadLocalRandom random = ThreadLocalRandom.current();
    private static final List<Integer> numbersRange = IntStream.rangeClosed(MINIMUM_LOTTO_NUMBER, MAXIMUM_LOTTO_NUMBER)
            .boxed()
            .collect(Collectors.toList());

    @Override
    public Set<LottoNumber> pickMain() {
        Collections.shuffle(numbersRange);

        return numbersRange.stream()
                .limit(LOTTO_NUMBERS_SIZE)
                .map(LottoNumber::new)
                .collect(Collectors.toUnmodifiableSet());
    }

    @Override
    public LottoNumber pickBonus() {
        final int bonusNumber = random.nextInt(MAXIMUM_LOTTO_NUMBER) + MINIMUM_LOTTO_NUMBER;

        return new LottoNumber(bonusNumber);
    }
}
