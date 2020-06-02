package lotto_step2.model;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        if(checkLotto(numbers)) {
            this.numbers = numbers;
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public PrizeMachine match(Lotto lastWeekLotto) {
        int matchCount = Math.toIntExact(lastWeekLotto.getNumbers().stream()
                .filter(number -> this.getNumbers().contains(number))
                .count());

        return PrizeMachine.matchPrize(matchCount);
    }

    public boolean checkLotto(List<Integer> numbers) {
        return numbers.stream().distinct().collect(Collectors.toList()).size() < 6 ?
                false : true;
    }
}

