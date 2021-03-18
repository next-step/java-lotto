package lottery.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottery {

    private final List<Integer> numbers;

    public Lottery(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public Prize getPrize(List<Integer> winningNumbers) {
        long matchedNumbers = numbers.stream()
                                     .filter(winningNumbers::contains)
                                     .count();

        return Prize.getPrize(matchedNumbers);
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }
}


