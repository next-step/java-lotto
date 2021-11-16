package lotto.model;

import java.util.List;

public class LotteryTicket {

    private static final int NUMBERS_COUNT = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private final List<Integer> numbers;

    public LotteryTicket(List<Integer> numbers) {
        checkNumbersSize(numbers);
        checkNumber(numbers);
        checkDuplicate(numbers);
        this.numbers = numbers;
    }

    private void checkDuplicate(List<Integer> numbers) {
        if(numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("중복된 번호가 있습니다.");
        }
    }

    private void checkNumber(List<Integer> numbers) {
        boolean rangeInvalid = numbers.stream()
                                    .anyMatch((number) -> number > MAX_NUMBER || number < MIN_NUMBER);
        if(rangeInvalid) {
            throw new IllegalArgumentException("번호는 1 ~ 45 사이의 숫자여야 합니다.");
        }
    }

    private void checkNumbersSize(List<Integer> numbers) {
        if(numbers.size() != NUMBERS_COUNT) {
            throw new IllegalArgumentException("6개 번호가 선택되어야 합니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}