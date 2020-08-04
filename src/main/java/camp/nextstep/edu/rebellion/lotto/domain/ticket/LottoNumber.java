package camp.nextstep.edu.rebellion.lotto.domain.ticket;

import java.util.Collections;
import java.util.List;

public class LottoNumber {
    private final List<Integer> numbers;

    public LottoNumber(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public boolean match(int number) {
        return this.numbers
                .stream()
                .anyMatch(n -> n == number);
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
