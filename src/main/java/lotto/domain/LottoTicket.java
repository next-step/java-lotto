package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoTicket {
    private static final int LOTTO_SIZE = 6;
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private final List<Integer> numbers;

    public LottoTicket(List<Integer> numbers) {
        validateSize(numbers.size());
        validateDuplicate(numbers);
        numbers.forEach(this::validateNumberRange);
        this.numbers = List.copyOf(numbers);
    }

    private void validateSize(int size) {
        if (size != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6개만 가능합니다.");
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> nonDuplicateNumbers = new HashSet<>(numbers);
        if (nonDuplicateNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("중복인 로또 번호가 존재합니다.");
        }
    }

    private void validateNumberRange(Integer number) {
        if (number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException("로또 번호는 1 이상 45 이하의 정수만 가능합니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
