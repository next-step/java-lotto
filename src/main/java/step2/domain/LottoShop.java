package step2.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoShop {
    private final static int INIT_INDEX = 0;
    private final static int LOTTO_PRICE_PER_PIECE = 1000;
    private final static String LOTTO_PRICE_EXCEPTION = "로또 구매 금액은 1000원 보다 작을 수 없습니다.";

    public LottoTickets buyLottoTickets(long price) {
        validatePrice(price);
        long lottoCounting = countLottoTicket(price);
        return new LottoTickets(publishLottoTickets(lottoCounting));
    }

    static void validatePrice(long price) {
        if (price < LOTTO_PRICE_PER_PIECE) {
            throw new IllegalArgumentException(LOTTO_PRICE_EXCEPTION);
        }
    }

    private long countLottoTicket(long price) {
        return Math.floorDiv(price, LOTTO_PRICE_PER_PIECE);
    }

    static List<LottoTicket> publishLottoTickets(long lottoCounting) {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        for (long i = INIT_INDEX; i < lottoCounting; i++) {
            lottoTickets.add(new LottoTicket().buyAuto());
        }
        return lottoTickets;
    }
}