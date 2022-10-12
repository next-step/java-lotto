package step2.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    private final List<LottoNumber> lottoNumbers = new ArrayList<>();

    private LottoGame() {
    }

    public static final LottoGame newInstance() {
        return new LottoGame();
    }

    public List<LottoNumber> playLotto(final Ticket ticket) {
        final int ticketCount = ticket.getTicketCount();
        for (int i = 0; i < ticketCount; i++) {
            lottoNumbers.add(LottoNumber.newInstance());
        }

        return lottoNumbers;
    }
}
