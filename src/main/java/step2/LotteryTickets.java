package step2;

import java.util.List;

class LotteryTickets {
    private final List<LotteryNumber> numbers;

    public LotteryTickets(List<LotteryNumber> numbers) {
        this.numbers = numbers;
    }

    public int size() {
        return numbers.size();
    }

    public List<LotteryNumber> getNumbers() {
        return numbers;
    }
}
