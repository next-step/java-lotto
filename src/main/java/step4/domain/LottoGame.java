package step4.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class LottoGame {

    private final List<LottoNumbers> lottoNumbers = new ArrayList<>();

    private LottoGame() {
    }

    public static final LottoGame newInstance() {
        return new LottoGame();
    }

    public List<LottoNumbers> playLotto(final Ticket ticket, List<Set<Integer>> manualLottoNumbers) {
        final int ticketCount = ticket.getCountOfTicket();
        for (Set manualLottoNumber : manualLottoNumbers) {
            lottoNumbers.add(LottoNumbers.from(
                LottoNumberGenerator.generateManualLottoNumber(manualLottoNumber)));
        }

        for (int i = 0; i < ticketCount; i++) {
            lottoNumbers.add(LottoNumbers.from(LottoNumberGenerator.generateAutoLottoNumber()));
        }
        return lottoNumbers;
    }
}
