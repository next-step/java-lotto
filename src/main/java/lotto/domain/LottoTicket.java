package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTicket {

    private final List<Integer> numbers;

    public LottoTicket() {
        numbers = new ArrayList<>();
    }

    public List<Integer> generate() {

        List<Integer> numbers = generateRandomNumbers();

        for (int i = 0; i < 6; i++) {
            this.numbers.add(numbers.get(i));
        }

        Collections.sort(this.numbers);

        return this.numbers;
    }

    protected List<Integer> generateRandomNumbers() {
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < 45; i++) {
            numbers.add(i + 1);
        }

        Collections.shuffle(numbers);
        return numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
