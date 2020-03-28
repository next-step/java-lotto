package lotto.domain.item;

import java.util.*;

public class LottoTicket implements Item {

    private static final int LOTTO_NUMBER_SIZE = 6;
    private static final int LOTTO_MIN_NUMBER_SIZE = 1;
    private static final int LOTTO_MAX_NUMBER_SIZE = 45;

    private final List<Integer> numbers;

    public LottoTicket() {
        this.numbers = new ArrayList<>();
    }

    public LottoTicket(List<Integer> numbers) {
        Collections.sort(numbers);
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
            if (i < LOTTO_MIN_NUMBER_SIZE || i > LOTTO_MAX_NUMBER_SIZE) {
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

    public int getCompareLuckNumberMatchCount(List<Integer> compare) {
        int match = 0;
        for (Integer num : numbers) {
            match = addCountIfMatch(compare, match, num);
        }

        return match;
    }

    private int addCountIfMatch(List<Integer> compare, int match, Integer num) {
        if (compare.contains(num)) {
            match++;
        }
        return match;
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
