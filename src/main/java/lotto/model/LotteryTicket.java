package lotto.model;

import java.util.List;

public class LotteryTicket {

    private final List<Integer> numbers;

    public LotteryTicket(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}