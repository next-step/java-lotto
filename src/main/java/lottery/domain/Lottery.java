package lottery.domain;

import java.util.List;

public class Lottery {

    private final List<Integer> numbers;

    public Lottery(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public Prize getPrize(Lottery winningLottery) {
        int matchedNumbers = numbers.stream()
                                    .filter(winningLottery.numbers::contains)
                                    .mapToInt(n -> 1)
                                    .sum();

        return Prize.getPrize(matchedNumbers);
    }

}


