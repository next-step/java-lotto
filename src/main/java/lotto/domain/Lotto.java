package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private static final int LOTTO_SIZE = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLottoSize(numbers);
        this.numbers = copyNumbers(numbers);
    }

    public List<Integer> retrieveNumbers() {
        return numbers;
    }

    public int retrieveCorrectLottoBallCount(Lotto winningLotto) {
        Long count = numbers.stream()
                .filter(winningLotto.numbers::contains)
                .count();
        return count.intValue();
    }

    private static void validateLottoSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("Lotto에는 " + LOTTO_SIZE + "개의 숫자만 들어올 수 있습니다.");
        }

    }

    private static List<Integer> copyNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::new)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "Lotto{" +
                "numbers=" + numbers +
                '}';
    }
}
