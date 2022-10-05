package lotto.domain.number;

import java.util.List;

public class Ticket implements LottoNumbers {

    private final List<Integer> numbers;

    public Ticket(List<Integer> numbers) {
        this.numbers = getValidatedNumbers(numbers);
    }

    @Override
    public List<Integer> getNumbers() {
        return numbers;
    }
}
