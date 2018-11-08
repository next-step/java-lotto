package domain;

import java.util.List;
import java.util.stream.Collectors;

public class Ticket {

    private List<Integer> numbers;

    public Ticket(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public int getCountOfMatches(Ticket winningNumbers) {
        int count = (int) this.numbers.stream()
                .filter(number -> winningNumbers.numbers.contains(number))
                .count();

        return count;
    }

    @Override
    public String toString() {
        String str = numbers.stream()
                .map(number -> String.valueOf(number))
                .collect(Collectors.joining(","));

        return str;
    }
}
