package lotto;

import lotto.domain.LottoTicket;

import java.util.Arrays;

public class LottoTicketFixture {
    public static LottoTicket of(Integer... lottoNumbers) {
        return LottoTicket.of(Arrays.asList(lottoNumbers));
    }
}
