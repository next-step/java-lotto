package lotto.number;

import lotto.exception.LottoIllegalArgumentException;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoBalls {
    public static final int NUMBER_OF_BALLS = 6;

    private final List<LottoNumber> balls;

    public LottoBalls(List<Integer> balls) {
        this(new HashSet<>(balls));
    }

    public LottoBalls(Set<Integer> balls) {
        validateNumberOfLottoNumbers(balls);
        this.balls = balls.stream()
                .map(LottoNumber::new)
                .sorted()
                .collect(Collectors.toUnmodifiableList());
    }

    private void validateNumberOfLottoNumbers(Set<Integer> lottoNumbers) {
        if (lottoNumbers.size() == NUMBER_OF_BALLS) {
            return;
        }
        throw LottoIllegalArgumentException.INVALID_LOTTO_NUMBERS_COUNT;
    }

    public int countMatchedNumber(LottoBalls otherBalls) {
        return (int) balls.stream()
                .filter(otherBalls::match)
                .count();
    }

    public boolean match(LottoNumber otherNumber) {
        return balls.contains(otherNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoBalls that = (LottoBalls) o;
        return Objects.equals(balls, that.balls);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(balls);
    }

    @Override
    public String toString() {
        return balls.toString();
    }
}
