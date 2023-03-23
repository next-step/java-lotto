package lotto.model;

import java.util.List;
import java.util.stream.Collectors;
public class LottoNumber {

    final private List<Integer> numbers;

    private Level level;

    public LottoNumber(List<Integer> numbers, Level level) {
        this.numbers = numbers;
        this.level = level;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Level getLevel() { return level; }

    public String printNumber() {

        return new StringBuilder("[")
                .append(numbers.stream()
                        .sorted()
                        .mapToInt(i->i.intValue())
                        .mapToObj(String::valueOf)
                        .collect(Collectors.joining(", ")))
                .append("]")
                .toString();
    }
    public long getWinningAmount() {
        return level.getAmount();
    }
}