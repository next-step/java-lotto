package lotto.Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TicketNumber {
    private static final int TICKET_SIZE = 6;

    private final List<Integer> numbers;

    public TicketNumber() {
        numbers = randomTicketNumber();
    }

    public TicketNumber(List<Integer> inputNumbers) {
        if (inputNumbers.size() != TICKET_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }

        List<Integer> numbers = new ArrayList<>();
        for (Integer number : inputNumbers) {
            LottoNumber lottoNumber = new LottoNumber(number);
            numbers.add(lottoNumber.number());
        }

        this.numbers = numbers;
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

    public boolean contain(int number) {
        return numbers.contains(number);
    }
}
