package lotto;

import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;

import java.util.Arrays;
import java.util.List;

public class LottoTicketFixture {
    public static LottoTicket of(Integer... lottoNumbers) {
        return LottoTicket.of(Arrays.asList(lottoNumbers));
    }
}
