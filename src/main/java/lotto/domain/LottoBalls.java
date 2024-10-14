package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoBalls {
    private final List<LottoNumber> lottoBalls;

    public LottoBalls() {
        this.lottoBalls = createLottoBalls();
    }

    private List<LottoNumber> createLottoBalls() {
        return IntStream.rangeClosed(LottoNumber.LOTTO_MIN_NUMBER, LottoNumber.LOTTO_MAX_NUMBER)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toUnmodifiableList());
    }

    public List<LottoNumber> generateShuffledBalls(int lottoBallsCount) {
        List<LottoNumber> shuffledBalls = new ArrayList<>(lottoBalls);
        Collections.shuffle(shuffledBalls);
        return shuffledBalls.stream()
                .limit(lottoBallsCount)
                .sorted()
                .collect(Collectors.toUnmodifiableList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoBalls that = (LottoBalls) o;
        return Objects.equals(lottoBalls, that.lottoBalls);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoBalls);
    }

    @Override
    public String toString() {
        return "LottoBalls{" +
                "lottoBalls=" + lottoBalls +
                '}';
    }
}
