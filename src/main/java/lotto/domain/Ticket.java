package lotto.domain;

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
        return (int) this.numbers.stream()
                .filter(number -> winningNumbers.numbers.contains(number))
                .count();
    }

    @Override
    public String toString() {
        return numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(","));
    }
}
