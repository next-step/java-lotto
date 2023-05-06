package lotto.Model;

import java.util.List;

public class Ticket {
    private final TicketNumber numbers;

    public Ticket(TicketNumber numbers) {
        this.numbers = numbers;
    }

    public TicketNumber numbers() {
        return numbers;
    }

    public int countMatches(List<Integer> winnerNumber) {
        int count = 0;
        for (Integer number : numbers.numbers()) {
            count += addIfMatch(winnerNumber, number);
        }
        return count;
    }

    private int addIfMatch(List<Integer> numbers, int number) {
        if (numbers.contains(number)) {
            return 1;
        }
        return 0;
    }

    public boolean contain(int bonusNumber) {
        return numbers.contain(bonusNumber);
    }
}
