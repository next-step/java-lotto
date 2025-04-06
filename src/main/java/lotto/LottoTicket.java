package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoTicket {

    public static final int PRICE_PER_TICKET = 1000;
    private static final int MAX_LOTTO_NUM = 45;
    private static final int LOTTO_NUM_COUNT = 6;
    private static final int MIN_LOTTO_NUM = 1;

    private final Set<Integer> numbers;
    private final Integer bonusNumber;

    public LottoTicket(List<Integer> numbers) {
        this(numbers, null);
    }

    public LottoTicket(List<Integer> numbers, Integer bonusNumber) {
        validateNumbers(numbers);
        if (bonusNumber != null) {
            validateBonusNumber(numbers, bonusNumber);
        }
        this.numbers = new HashSet<>(numbers);
        this.bonusNumber = bonusNumber;
    }

    public LottoTicket(String numbersStr, String bonusNumberStr) {
        this(parseNumbers(numbersStr), parseNumber(bonusNumberStr));
    }

    private static List<Integer> parseNumbers(String numbersStr) {
        if (numbersStr == null || numbersStr.isBlank()) {
            throw new IllegalArgumentException("입력값이 없습니다.");
        }

        List<Integer> numbers = new ArrayList<>();
        for (String numberStr : numbersStr.split(",")) {
            numbers.add(parseNumber(numberStr));
        }
        return numbers;
    }

    private static int parseNumber(String numberStr) {
        try {
            return Integer.parseInt(numberStr.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("로또 번호는 숫자여야 합니다.");
        }
    }

    private void validateNumbers(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUM_COUNT) {
            throw new IllegalArgumentException("로또 티켓은 6개의 숫자로 이루어져 있어야 합니다.");
        }

        for (Integer number : numbers) {
            validateNumber(number);
        }

        if (numbers.stream().distinct().count() != LOTTO_NUM_COUNT) {
            throw new IllegalArgumentException("로또 티켓은 중복된 숫자를 포함할 수 없습니다.");
        }
    }

    private void validateNumber(Integer number) {
        if (number == null) {
            throw new IllegalArgumentException("로또 번호는 null일 수 없습니다.");
        }

        if (number < MIN_LOTTO_NUM || number > MAX_LOTTO_NUM) {
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private void validateBonusNumber(List<Integer> numbers, Integer bonusNumber) {
        validateNumber(bonusNumber);
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 로또 번호와 중복될 수 없습니다.");
        }
    }

    public Set<Integer> getNumbers() {
        return this.numbers;
    }

    public int countMatches(LottoTicket other) {
        if (other == null) {
            throw new IllegalArgumentException("비교할 번호는 null일 수 없습니다.");
        }

        int count = 0;
        for (int number : numbers) {
            if (other.numbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
