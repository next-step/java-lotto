package lotto.service;

import lotto.domain.LottoTickets;
import lotto.exception.MinimumAmountException;
import lotto.util.AutoLottoNumberUtils;

public class LottoTicketBooth {

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
            lottoTickets = lottoTickets.add(AutoLottoNumberUtils.getAutoLottoNumber());
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
}
