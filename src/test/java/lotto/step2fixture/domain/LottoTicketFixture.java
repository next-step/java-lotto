package lotto.step2fixture.domain;

import lotto.step2.domain.LottoTicket;

import java.util.Arrays;

public class LottoTicketFixture {
    public static final LottoTicket LOTTO_TICKET = new LottoTicket(Arrays.asList(LottoNumberFixture.ONE, LottoNumberFixture.TWO, LottoNumberFixture.THREE, LottoNumberFixture.FOUR, LottoNumberFixture.FIVE, LottoNumberFixture.SIX));
}
