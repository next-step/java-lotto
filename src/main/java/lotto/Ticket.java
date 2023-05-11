package lotto;

import java.util.List;

public class Ticket {
    List<Integer> numbers;

    private Ticket(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static Ticket from(List<Integer> numbers) {
        return new Ticket(numbers);
    }

    public boolean checkValidTickets() {
        return numbers.stream().allMatch(num -> num >= 1 && num <= 45);
    }

    public int numberOfMatching(List<Integer> winningNumber) {
        return (int) winningNumber.stream().filter(w -> numbers.contains(w)).count();
    }
}
