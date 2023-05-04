package lottery.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Lottery {
    private final List<Integer> numbers;

    private Lottery(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers);
        Collections.sort(this.numbers);
    }

    public static Lottery createLottery(List<Integer> numbers) {
        List<Integer> copyOfNumbers = new ArrayList<>(numbers);
        return new Lottery(copyOfNumbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != Lotteries.LOTTERY_LENGTH || checkIfNotInRange(numbers)) {
            throw new IllegalArgumentException(String.format("%s is not valid ", numbers));
        }
    }

    private static boolean checkIfNotInRange(List<Integer> numbers) {
        boolean isValid = true;
        for (Integer number : numbers) {
            isValid = isValid && number >= Lotteries.MIN_LOTTERY_NUMBER && number <= Lotteries.MAX_LOTTERY_NUMBER;
        }
        return !isValid;
    }

    public List<Integer> numbers() {
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
