package lotto.number;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoBalls {
    public static final int NUMBER_OF_BALLS = 6;

    private final Set<LottoNumber> balls;

    public LottoBalls(List<Integer> balls) {
        this(new HashSet<>(balls));
    }

    public LottoBalls(Set<Integer> balls) {
        validateNumberOfLottoNumbers(balls);
        this.balls = balls.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toUnmodifiableSet());
    }

    private static void validateNumberOfLottoNumbers(Set<Integer> lottoNumbers) {
        if (lottoNumbers.size() == NUMBER_OF_BALLS) {
            return;
        }
        throw new IllegalArgumentException("로또 번호는 6개 입니다.");
    }

    public int matchLottoBalls(LottoBalls otherBalls) {
        return (int) balls.stream()
                .filter(otherBalls::match)
                .count();
    }

    public boolean match(LottoNumber otherNumber) {
        return balls.contains(otherNumber);
    }

    @Override
    public String toString() {
        return balls.toString();
    }

}
