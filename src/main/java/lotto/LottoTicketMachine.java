package lotto;

import java.util.List;

public class LottoTicketMachine {
    public static LottoTicket issue() {
        return new LottoTicket(List.of(1, 2, 3, 4, 5, 6));
    }
}
