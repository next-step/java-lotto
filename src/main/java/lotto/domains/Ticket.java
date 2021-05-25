package lotto.domains;

import java.util.List;

import lotto.tool.TicketGuard;
import lotto.tool.TicketTokenizer;

public class Ticket {

    private List<Integer> numbers;

    public Ticket(String text) {
        this(TicketTokenizer.tokenize(text));
    }

    public Ticket(List<Integer> numbers) {
        this.numbers = TicketGuard.guard(numbers);
    }

    public boolean contains(int number) {
        return this.numbers.contains(number);
    }

    public int countSameNumbers(Ticket other) {
        int count = 0;
        for (int number : this.numbers) {
            count += countIfContains(other, number);
        }
        return count;
    }

    private int countIfContains(Ticket other, int number) {
        if (other.contains(number)) {
            return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
