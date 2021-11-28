package lotto.service;

import java.util.List;
import lotto.domain.LottoTickets;
import lotto.domain.Money;
import lotto.exception.MinimumAmountException;
import lotto.util.AutoLottoNumberUtils;

public class LottoTicketBooth implements LottoTicketsGenerator {

    public LottoTickets generate(Money money) {
        money.autoCount();
        return null;
    }

    public LottoTickets generate(List<String> manualLottoNumbers) {
        return null;
    }

    private static class LottoTicketBoothHolder {

        private static final LottoTicketBooth LOTTO_TICKET_BOOTH = new LottoTicketBooth();
    }

    private static final long TICKET_PRICE = 1000l;
    private static final int MINIMUM_COUNT = 1;

    private LottoTicketBooth() {
    }

    public static LottoTicketBooth getInstance() {
        return LottoTicketBoothHolder.LOTTO_TICKET_BOOTH;
    }

    public LottoTickets autoTickets(int money) {
        int count = getCount(money);
        LottoTickets lottoTickets = new LottoTickets();
        for (int i = 0; i < count; i++) {
            lottoTickets = this.addLottoTicket(lottoTickets, AutoLottoNumberUtils.getAutoLottoNumber());
        }
        return lottoTickets;
    }

    private int getCount(int money) {
        int count = (int) Math.floor(money / TICKET_PRICE);
        if (count < MINIMUM_COUNT) {
            throw new MinimumAmountException(TICKET_PRICE);
        }
        return count;
    }

    private LottoTickets addLottoTicket(LottoTickets lottoTickets, List<Integer> lottoTicket) {
        return lottoTickets.add(lottoTicket);
    }

}
