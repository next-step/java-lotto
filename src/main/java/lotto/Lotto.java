package lotto;

import java.util.List;

public class Lotto {
    private List<Integer> numbers;

    public Lotto() {
        LottoNumGenerator lg = new AutoLottoNumGenerator();
        numbers = lg.generate();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getMatchCount(List<Integer> winningNumbers) {
        return numbers.stream()
                .filter(i -> winningNumbers.contains(i))
                .map(i -> 1)
                .mapToInt(Integer::valueOf)
                .sum();
    }
}
