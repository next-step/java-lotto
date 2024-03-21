package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTicket {

    private final List<Integer> numbers;
    private static final int MAX_NUMBERS = 6;

    public LottoTicket() {
        numbers = new ArrayList<>();
    }

    public List<Integer> generate() {
        for (int i = 0; i < MAX_NUMBERS; i++) {
            this.numbers.add(randomNumbers().get(i));
        }
        Collections.sort(this.numbers);
        return this.numbers;
    }

    protected List<Integer> randomNumbers() {
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < 45; i++) {
            numbers.add(i + 1);
        }

        Collections.shuffle(numbers);
        return numbers;
    }

    public int countMatchingWith(List<Integer> winningNumbers) {
        return Math.toIntExact(this.numbers.stream()
                .filter(winningNumbers::contains)
                .count());
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
