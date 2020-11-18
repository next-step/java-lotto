package step2.domain;

import java.util.Set;

public class LotteryTickets {
    private final Set<LotteryNumber> numbers;

    public LotteryTickets(Set<LotteryNumber> numbers) {
        this.numbers = numbers;
    }

    public int size() {
        return numbers.size();
    }

    public Set<LotteryNumber> getTicketNumbers() {
        return numbers;
    }
}
