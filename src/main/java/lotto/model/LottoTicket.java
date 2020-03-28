package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static lotto.utils.LottoConstant.*;

public abstract class LottoTicket {
    protected List<Integer> numbers;

    protected LottoTicket(final List<Integer> numbers) {
        validate(numbers);

        Collections.sort(numbers);

        this.numbers = new ArrayList<>(numbers);
    }

    public Integer[] toArray() {
        return numbers.toArray(new Integer[0]);
    }

    private void validate(final List<Integer> numbers) {
        validateNullOrEmpty(numbers);

        List<Integer> distinctNumbers = numbers.stream()
                .distinct()
                .collect(Collectors.toList());
        validateDistinct(distinctNumbers);
    }

    private void validateNullOrEmpty(List<Integer> numbers) {
        if(Objects.isNull(numbers) || numbers.isEmpty()) {
            throw new IllegalArgumentException("lotto numbers is null or empty");
        }
    }

    private void validateDistinct(List<Integer> numbers) {
        validateNumberRange(numbers);
        validateSize(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        int size = (int) numbers.stream()
                .distinct()
                .count();
        if (size != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("Lotto Ticket must have six distinct number.");
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        boolean isAnyOutOfRange = numbers.stream()
                .anyMatch(number -> number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER);
        if(isAnyOutOfRange) {
            throw new IllegalArgumentException("Lotto Ticket must have six distinct number.");
        }
    }
}
