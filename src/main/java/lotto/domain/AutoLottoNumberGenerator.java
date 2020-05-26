package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class AutoLottoNumberGenerator implements LottoNumberGenerator {
    private final List<Integer> lottoBalls;

    public AutoLottoNumberGenerator() {
        this.lottoBalls = IntStream.rangeClosed(LottoNumberSetting.BEGIN_BOUND.getValue(), LottoNumberSetting.END_BOUND.getValue())
                .boxed()
                .collect(toList());
    }

    @Override
    public Set<Integer> generate() {
        Collections.shuffle(lottoBalls);
        return Collections.unmodifiableSet(new HashSet<>(pickLottoBalls()));
    }

    private List<Integer> pickLottoBalls() {
        return lottoBalls.subList(0, LottoNumberSetting.COUNT_OF_BALL.getValue());
    }
}
