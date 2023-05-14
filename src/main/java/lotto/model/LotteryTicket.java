package lotto.model;

import java.util.Set;

public class LotteryTicket {

    private final Set<LotteryNumber> numbers;

    protected LotteryTicket(Set<LotteryNumber> numbers) {
        this.numbers = numbers;
    }

    public static LotteryTicket of(LotteryNumberGenerator numberGenerator) {
        return new LotteryTicket(numberGenerator.generate());
    }

    public int matchCount(WinNumbers winNumbers) {
        return winNumbers.matchCount(this.numbers);
    }

    public int size() {
        return this.numbers.size();
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

}
