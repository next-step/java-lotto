package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoTicket {
    private static final int LOTTO_NUMBERS_SIZE = 6;
    private final List<Integer> numbers;

    public LottoTicket(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplication(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if(numbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException("[ERROR] 로또 넘버는 6개여야 합니다.");
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        Set<Integer> nonDuplicateNumbers = new HashSet<>(numbers);
        if(nonDuplicateNumbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException("[ERROR] 로또 넘버는 중복이 불가합니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
