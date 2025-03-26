package lotto;

import java.util.List;

public class LottoTicketMachine {

    public static Lotto issue() {
        return new Lotto(List.of(1, 2, 3, 4, 5, 6));
    }
}
