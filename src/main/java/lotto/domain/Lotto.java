package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    public static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_SIZE = 6;

    private final Set<LottoBall> numbers;

    public Lotto(Lotto lotto) {
        numbers = copyLotto(lotto);
    }

    public Lotto(List<Integer> numbers) {
        this.numbers = makeLottoBalls(numbers);
        validateLottoSize();
    }

    public Set<LottoBall> retrieveNumbers() {
        return Collections.unmodifiableSet(numbers);
    }

    public int retrieveWinnerLottoBallCount(Lotto lotto) {
        Long count = this.numbers.stream()
                .filter(lotto.numbers::contains)
                .count();
        return count.intValue();
    }

    public boolean hasLottoBall(LottoBall lottoBall) {
        return numbers.stream()
                .anyMatch(lottoBall::equals);
    }

    private void validateLottoSize() {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("Lotto에는 " + LOTTO_SIZE + "개의 중복되지 않은 숫자만 들어올 수 있습니다.");
        }
    }

    private Set<LottoBall> makeLottoBalls(List<Integer> numbers) {
        return numbers.stream()
                .map(LottoBall::from)
                .collect(Collectors.toSet());
    }

    private Set<LottoBall> copyLotto(Lotto lotto) {
        return new HashSet<>(lotto.numbers);
    }

    @Override
    public String toString() {
        return "Lotto{" +
                "numbers=" + numbers +
                '}';
    }
}
