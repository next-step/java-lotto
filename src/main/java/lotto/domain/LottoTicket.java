package lotto.domain;

import lotto.domain.LottoTicketGenerator;
import java.util.Collections;
import java.util.List;

public class LottoTicket {

    private static final int LOTTO_PRICE = 1_000;

    final List<Lotto> lottoTicket;
    final int price;

    private LottoTicket(int price) {
        final int lottoCount = convertPriceToCount(price);

        this.price = price;
        this.lottoTicket = LottoTicketGenerator.from(lottoCount).getLottoTicket();
    }

    public static LottoTicket from(int price) {
        return new LottoTicket(price);
    }

    private int convertPriceToCount(int price) {
        return price / LOTTO_PRICE;
    }

    public List<Lotto> getLottoTicket() {
        return Collections.unmodifiableList(lottoTicket);
    }

    public int getLottoTicketPrice() {
        return price;
    }

}
