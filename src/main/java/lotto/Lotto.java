package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

    private static final int WINNING_CRITERIA = 3;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateNumbers(numbers);
        this.numbers = new ArrayList<>(numbers);
    }

    public Lotto(LottoNumberGenerator generator) {
        this(generator.generate());
    }

    private void validateNumbers(List<Integer> numbers) {
        if (numbers.size() != LottoRules.LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
        if (numbers.stream()
            .anyMatch(n -> n < LottoRules.MIN_NUMBER || n > LottoRules.MAX_NUMBER)) {
            throw new IllegalArgumentException("로또 번호는 1~45 사이여야 합니다.");
        }
    }

    public int countMatchWith(Lotto other) {
        return (int) numbers.stream()
            .filter(other.getNumbers()::contains)
            .count();
    }

    public boolean isWinningLotto(Lotto winningLotto) {
        return countMatchWith(winningLotto) >= WINNING_CRITERIA;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
