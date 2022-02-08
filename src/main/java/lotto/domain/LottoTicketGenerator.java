package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTicketGenerator {

    private final List<Lotto> lottoTicket;

    private LottoTicketGenerator(int count) {
        this.lottoTicket = generateLottoTicket(count);
    }

    public static LottoTicketGenerator from(int count) {
        return new LottoTicketGenerator(count);
    }

    public List<Lotto> getLottoTicket() {
        return Collections.unmodifiableList(lottoTicket);
    }

    private List<Lotto> generateLottoTicket(int count) {
        List<Lotto> lottoTicket = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            lottoTicket.add(new Lotto());
        }

        return lottoTicket;
    }
}
