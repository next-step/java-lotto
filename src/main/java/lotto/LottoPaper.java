package lotto;

import java.util.List;

public class LottoPaper {

    private List<Integer> numbers;

    public LottoPaper() {
        this(null);
    }

    public LottoPaper(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public void applyNumber(Integer number) {
        this.numbers.add(number);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
