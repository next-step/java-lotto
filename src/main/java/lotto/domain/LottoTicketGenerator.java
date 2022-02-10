package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoTicketGenerator {

    private static final int LOTTO_PRICE = 1_000;

    final LottoTicket lottoTicket;

    private LottoTicketGenerator(LottoTicket lottoTicket) {
        this.lottoTicket = lottoTicket;
    }

    public static LottoTicketGenerator from(Price price) {
        LottoTicket lottoTicket = generateLottoTicketFromPrice(price);

        return new LottoTicketGenerator(lottoTicket);
    }

    public LottoTicket getLottoTicket() {
        return lottoTicket;
    }

    private static LottoTicket generateLottoTicketFromPrice(Price price) {
        int count = convertPriceToCount(price.getValue());
        List<Lotto> lottoTicket = generateLottoTicket(count);

        return LottoTicket.from(lottoTicket, price.getValue());
    }

    private static List<Lotto> generateLottoTicket(int count) {
        List<Lotto> lottoList = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            lottoList.add(new Lotto());
        }

        return lottoList;
    }

    private static int convertPriceToCount(int price) {
        return price / LOTTO_PRICE;
    }
}
