package lottos.domain;

import lottos.domain.numbers.Numbers;

import java.util.List;

public class Lotto {

    private final Numbers numbers;

    public Lotto(final List<Integer> numbers) {
        this.numbers = Numbers.from(numbers);
    }

    public Lotto(final Numbers numbers) {
        this.numbers = numbers;
    }

    public Numbers getNumbers() {
        return numbers;
    }
}
