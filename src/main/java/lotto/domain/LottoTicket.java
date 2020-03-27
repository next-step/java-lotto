package lotto.domain;

import java.util.*;

public class LottoTicket {

    private static final int LOTTO_NUMBER_SIZE = 6;
    private static final int LOTTO_Min_NUMBER_SIZE = 1;
    private static final int LOTTO_MAX_NUMBER_SIZE = 45;

    private final List<Integer> numbers;

    public LottoTicket(List<Integer> numbers) {
        validateSize(numbers);
        validateNumberRange(numbers);
        validateDuplicate(numbers);
        
        List<Integer> result = new ArrayList<>();
        result.addAll(numbers);
        this.numbers = Collections.unmodifiableList(result);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("번호는 6개만 지정 가능 합니다.");
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        for (Integer i : numbers) {
            if (i < 1 || i > 45) {
                throw new IllegalArgumentException("번호는 1~ 45 사이의 정수만 가능 합니다.");
            }
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> duplicate = new HashSet<>(numbers);
        if (numbers.size() != duplicate.size()) {
            throw new IllegalArgumentException("번호는 중복될 수 없습니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoTicket that = (LottoTicket) o;
        return Objects.equals(numbers, that.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
