package lotto.domain;

import lotto.exception.TicketNumbersCountException;

import java.util.List;

public class Ticket {
    private final List<Integer> numbers;
    public Ticket(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> purchaseGame) {
        throw new TicketNumbersCountException();
    }

    public String rendering() {
        throw new RuntimeException("문자열 출력되도록 구현해야함 구분자는 [, ] 로 ");
    }
}
