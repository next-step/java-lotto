package lotto.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class LotteryTicket {

    private final Set<LotteryNumber> numbers;

    protected LotteryTicket(Set<LotteryNumber> numbers) {
        this.numbers = numbers;
    }

    public static LotteryTicket of(LotteryNumberGenerator numberGenerator) {
        return new LotteryTicket(numberGenerator.generate());
    }

    public double matchCount(WinNumbers winNumbers) {
        return winNumbers.matchCount(this.numbers);
    }

    public int size() {
        return this.numbers.size();
    }

    @Override
    public String toString() {
        List<LotteryNumber> numberList = new ArrayList<>(numbers);
        numberList.sort(Comparator.comparing(LotteryNumber::value));
        return numberList.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LotteryTicket that = (LotteryTicket) o;
        return Objects.equals(numbers, that.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

}
