package lotto.domain;

import java.util.Arrays;

public class LottoTicketFixtures {
    public static final LottoTicket LOTTO_TICKET_123456 = new LottoTicket(
            Arrays.asList(
                    new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                    new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)
                    )
    );

    public static final LottoTicket LOTTO_TICKET_234567 = new LottoTicket(
            Arrays.asList(
                    new LottoNumber(2), new LottoNumber(3), new LottoNumber(4),
                    new LottoNumber(5), new LottoNumber(6), new LottoNumber(7)
            )
    );

    public static final LottoTicket LOTTO_TICKET_345678 = new LottoTicket(
            Arrays.asList(
                    new LottoNumber(3), new LottoNumber(4), new LottoNumber(5),
                    new LottoNumber(6), new LottoNumber(7), new LottoNumber(8)
            )
    );

    public static final LottoTicket LOTTO_TICKET_101112131415 = new LottoTicket(
            Arrays.asList(
                    new LottoNumber(10), new LottoNumber(11), new LottoNumber(12),
                    new LottoNumber(13), new LottoNumber(14), new LottoNumber(15)
            )
    );
}
