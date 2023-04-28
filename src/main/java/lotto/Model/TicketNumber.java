package lotto.Model;

import java.util.List;

public class TicketNumber {
    private static final int TICKET_SIZE = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private final List<Integer> numbers;

    public TicketNumber(List<Integer> numbers) {
        if (numbers.size() != TICKET_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }

        if (containNotValidNumber(numbers)) {
            throw new IllegalArgumentException("로또 번호는 1부터 45까지의 숫자여야 합니다.");
        }

        this.numbers = numbers;
    }

    private boolean containNotValidNumber(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < MIN_NUMBER || number > MAX_NUMBER) {
                return true;
            }
        }

        return false;
    }

    public List<Integer> numbers() {
        return numbers;
    }
}
