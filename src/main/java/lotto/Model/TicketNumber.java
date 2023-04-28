package lotto.Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TicketNumber {
    private static final int TICKET_SIZE = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private final List<Integer> numbers;

    public TicketNumber() {
        numbers = randomTicketNumber();
    }

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
        Collections.sort(numbers);

        if (numbers.get(0) < MIN_NUMBER) {
            return true;
        }

        return numbers.get(numbers.size() - 1) > MAX_NUMBER;
    }

    public List<Integer> numbers() {
        return numbers;
    }

    private List<Integer> randomTicketNumber() {
        List<Integer> numList = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            numList.add(i);
        }
        Collections.shuffle(numList);

        List<Integer> ticketNumber = numList.subList(0, 6);
        Collections.sort(ticketNumber);
        return ticketNumber;
    }
}
