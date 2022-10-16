package step2.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    private final List<LottoNumbers> lottoNumbers = new ArrayList<>();

    private LottoGame() {
    }

    public static final LottoGame newInstance() {
        return new LottoGame();
    }

    public List<LottoNumbers> playLotto(final Ticket ticket) {
        final int ticketCount = ticket.getTicketCount();
        for (int i = 0; i < ticketCount; i++) {
            lottoNumbers.add(LottoNumbers.newInstance());
        }

        return lottoNumbers;
    }
}
