package lottery.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Lottery {
    private final List<LotteryNumber> numbers;

    private Lottery(List<LotteryNumber> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers);
        Collections.sort(this.numbers);
    }

    public static Lottery createLottery(List<LotteryNumber> numbers) {
        List<LotteryNumber> copyOfNumbers = new ArrayList<>(numbers);
        return new Lottery(copyOfNumbers);
    }

    private void validate(List<LotteryNumber> numbers) {
        if (numbers.size() != Lotteries.LOTTERY_LENGTH) {
            throw new IllegalArgumentException(String.format("%s is not valid ", numbers));
        }
    }

    public List<LotteryNumber> numbers() {
        return new ArrayList<>(numbers);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lottery lottery = (Lottery) o;
        return Objects.equals(numbers, lottery.numbers);
    }
}
