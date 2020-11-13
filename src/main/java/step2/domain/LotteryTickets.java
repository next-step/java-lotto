package step2.domain;

import java.util.List;

public class LotteryTickets {
    private final List<LotteryNumber> numbers;

    public LotteryTickets(List<LotteryNumber> numbers) {
        this.numbers = numbers;
    }

    public int size() {
        return numbers.size();
    }

    public List<LotteryNumber> listTicketNumbers() {
        return numbers;
    }
}
