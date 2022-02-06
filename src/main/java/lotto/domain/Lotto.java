package lotto.domain;

import java.util.HashSet;
import java.util.Set;

public class Lotto {

    private static final int LOTTO_NUMBERS_SIZE = 6;
    private final Numbers numbers;

    public Lotto(Numbers numbers) {
        this.numbers = numbers;
        validateSize();
        validateDuplication();
    }

    private void validateSize() {
        if (numbers.getSize() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException("[ERROR] 로또 넘버는 6개여야 합니다.");
        }
    }

    private void validateDuplication() {
        Set<Integer> nonDuplicateNumbers = new HashSet<>(numbers.getRawValues());
        if (nonDuplicateNumbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException("[ERROR] 로또 넘버는 중복이 불가합니다.");
        }
    }
}
