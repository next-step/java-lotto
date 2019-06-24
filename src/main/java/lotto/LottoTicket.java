package lotto;

import java.util.List;

public class LottoTicket {
    private List<Integer> ticket;

    public LottoTicket(List<Integer> numbers) {
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