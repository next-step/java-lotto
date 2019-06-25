package lotto;

import java.util.List;

public class LottoTicket {
    private List<Integer> ticket;

    public LottoTicket(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또의 숫자는 6개이여야 합니다.");
        }

        this.ticket = numbers;
    }

    public int correctWith(LottoTicket another) {
        int result = 0;
        for (Integer number : ticket) {
            result += another.oneIfHas(number);
        }

        return result;
    }

    public int oneIfHas(int number) {
        return this.ticket.contains(number) ? 1 : 0;
    }
}