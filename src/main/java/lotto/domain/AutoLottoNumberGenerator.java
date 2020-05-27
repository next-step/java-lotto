package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;
import static lotto.domain.LottoGameProperty.*;

public class AutoLottoNumberGenerator implements LottoNumberGenerator {
    private final List<Integer> lottoBalls;

    public AutoLottoNumberGenerator() {
        this.lottoBalls = IntStream.rangeClosed(LOTTO_NUMBER_BEGIN_BOUND, LOTTO_NUMBER_END_BOUND)
                .boxed()
                .collect(toList());
    }

    @Override
    public Set<Integer> generate() {
        Collections.shuffle(lottoBalls);
        return Collections.unmodifiableSet(new HashSet<>(pickLottoBalls()));
    }

    private List<Integer> pickLottoBalls() {
        return lottoBalls.subList(0, COUNT_OF_LOTTO_NUMBER);
    }
}
