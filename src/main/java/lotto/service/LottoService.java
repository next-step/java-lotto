package lotto.service;

import lotto.domain.LottoTickets;
import lotto.util.AutoLottoNumberUtils;

public class LottoService {

    private static final int TICKET_PRICE = 1000;
    private static final int MINIMUM_COUNT = 1;
    private static LottoService lottoService;

    private LottoService() {
    }

    public static LottoService getInstance() {
        if (lottoService == null) {
            lottoService = new LottoService();
        }
        return lottoService;
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
        if(count < MINIMUM_COUNT) {
            throw new IllegalArgumentException(String.format("금액은 %d원 이상이어야 합니다.", TICKET_PRICE));
        }
        return count;
    }

}
