package lotto.model;

import java.util.List;

public class LottoNumber {

    private List<Integer> numbers;

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

        return numbers.toString();
    }
    public long getWinningAmount() {
        return level.getAmount();
    }
}
