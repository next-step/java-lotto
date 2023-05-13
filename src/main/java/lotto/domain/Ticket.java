package lotto.domain;

import lombok.Getter;

import java.util.List;

public class Ticket {
    @Getter
    private List<Integer> numbers;
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;

    private Ticket(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static Ticket from(List<Integer> numbers) {
        return new Ticket(numbers);
    }

    public boolean checkValidTickets() {
        return numbers.stream().allMatch(num -> num >= MIN_LOTTO_NUMBER && num <= MAX_LOTTO_NUMBER);
    }

    public int numberOfMatching(List<Integer> winningNumber) {
        return (int) winningNumber.stream()
                .filter(w -> numbers.contains(w))
                .count();
    }
}
