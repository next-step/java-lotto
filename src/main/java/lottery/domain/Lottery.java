package lottery.domain;

import lottery.dto.ReadonlyLottery;

import java.util.ArrayList;
import java.util.List;

public class Lottery implements ReadonlyLottery {

    private final List<Integer> numbers;

    public Lottery(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public Prize getPrize(List<Integer> winningNumbers) {
        int matchedNumbers = numbers.stream()
                                    .filter(winningNumbers::contains)
                                    .mapToInt(n -> 1)
                                    .sum();

        return Prize.getPrize(matchedNumbers);
    }

    @Override
    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }
}


