package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    public static final int LOTTO_PRICE = 1000;
    private final LottoNumberExtractor lottoNumberExtractor;

    public LottoMachine(LottoNumberExtractor lottoNumberExtractor) {
        this.lottoNumberExtractor = lottoNumberExtractor;
    }

    public LottoTickets makeLottoTickets(int price) {
        int count = price / LOTTO_PRICE;
        List<LottoTicket> lottoTicketList = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            lottoTicketList.add(makeAutoLottoTicket());
        }

        return new LottoTickets(lottoTicketList);
    }

    public LottoTicket makeAutoLottoTicket() {
        return new LottoTicket(lottoNumberExtractor.getNumbers(LottoTicket.LOTTO_SIZE));
    }
}
