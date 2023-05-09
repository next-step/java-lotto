package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private static final int DRAW_NUMBER = 6;

    private final List<LottoNumber> numbers;

    public Lotto(List<Integer> numbers) {
        checkValid(numbers);
        this.numbers = numbers.stream()
            .map(LottoNumber::new)
            .collect(Collectors.toList());
    }

    public int scoreHit(Lotto winningNumber) {
        return (int) numbers.stream()
            .filter(winningNumber::contains)
            .count();
    }

    private boolean contains(LottoNumber lottoNumber) {
        return this.numbers.contains(lottoNumber);
    }

    private void checkValid(List<Integer> numbers) {
        if (numbers == null || numbers.size() != DRAW_NUMBER) {
            throw new IllegalArgumentException("In Lotto entered not supported argument");
        }
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
