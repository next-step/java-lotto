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
        return (int)this.numbers.stream().filter(other::contains).count();
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
