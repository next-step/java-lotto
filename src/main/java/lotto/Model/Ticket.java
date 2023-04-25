package lotto.Model;

import java.util.List;

public class Ticket {
    private static final int TICKET_SIZE = 6;
    private final List<Integer> numbers;

    public Ticket(List<Integer> numbers) {
        if (numbers.size() != TICKET_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }

        this.numbers = numbers;
    }

    public List<Integer> numbers() {
        return numbers;
    }
}
