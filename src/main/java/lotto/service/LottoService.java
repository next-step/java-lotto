package lotto.service;

import lotto.domain.LottoTickets;

public class LottoService {

    private static final int TICKET_PRICE = 1000;

    static LottoService lottoService;

    private LottoService() {
    }

    public static LottoService getInstance() {
        if (lottoService == null) {
            lottoService = new LottoService();
        }
        return lottoService;
    }

    public LottoTickets buyLottoTickets(Integer money) {
        LottoTickets lottoTickets = new LottoTickets();
        return lottoTickets.autoLottoTicket(getCount(money));
    }

    private int getCount(Integer money) {
        if (money == null || money < TICKET_PRICE) {
            throw new IllegalArgumentException(String.format("티켓의 최소 가격은 %d 입니다.", TICKET_PRICE));
        }
        return (int) Math.floor(money / TICKET_PRICE);
    }
}
