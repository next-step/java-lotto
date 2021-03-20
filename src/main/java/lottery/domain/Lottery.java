package lottery.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottery {

    private final List<Integer> numbers;

    public Lottery(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public Prize getPrize(List<Integer> winningNumbers, int bonusNumber) {
        long matchedNumbers = numbers.stream()
                                     .filter(winningNumbers::contains)
                                     .count();
        boolean bonusNumberMatched = numbers.contains(bonusNumber);

        return Prize.getPrize(matchedNumbers, bonusNumberMatched);
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }
}


