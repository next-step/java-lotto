package lotto.domain;

import lotto.domain.ticket.LottoTicket;
import lotto.domain.ticket.LottoTickets;
import lotto.vo.Money;

import java.util.ArrayList;
import java.util.List;

import static lotto.domain.LottoGameProperty.LOTTO_TICKET_PRICE;

public class LottoStore {
    private final LottoNumberGenerator lottoNumberGenerator;

    public LottoStore(final LottoNumberGenerator lottoNumberGenerator) {
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    public LottoTickets buy(final Money budget) {
        Money currentMoney = budget;
        List<LottoTicket> lottoTickets = new ArrayList<>();

        while (currentMoney.isEnoughToBuy(LOTTO_TICKET_PRICE)) {
            lottoTickets.add(new LottoTicket(lottoNumberGenerator.generate()));
            currentMoney = currentMoney.spend(LOTTO_TICKET_PRICE);
        }

        return new LottoTickets(lottoTickets);
    }

}
