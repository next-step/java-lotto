package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {

    private static final int LOTTO_PRICE = 1000;
    private final int ticketCounts;
    private final List<Lotto> lottoTickets;

    public LottoTickets(final int payment) {
        this.ticketCounts = payment / LOTTO_PRICE;
        this.lottoTickets = makeLottoTickets(ticketCounts);
    }

    public LottoTickets(final int payment, List<Lotto> lottoTickets) {
        this.ticketCounts = payment / LOTTO_PRICE;
        this.lottoTickets = lottoTickets;
    }

    private List<Lotto> makeLottoTickets(final int lottoCount) {
        final List<Lotto> lottoTickets = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottoTickets.add(new Lotto());
        }
        return lottoTickets;
    }

    public int getTicketCounts() {
        return this.ticketCounts;
    }

    public List<Lotto> getLottoTickets() {
        return lottoTickets;
    }

    public List<Integer> countNumberOfMatches(LottoMachine lottoMachine) {
        List<Integer> correctNumbers = new ArrayList<>();
        for (Lotto lotto : lottoTickets) {
            correctNumbers.add(lotto.compareLottoAndWinnerNumbers(lottoMachine));
        }
        return correctNumbers;
    }

    public List<Integer> checkBonusNumber(final LottoMachine lottoMachine) {
        final List<Integer> checkBonusNumber = new ArrayList<>();
        for (Lotto lotto : lottoTickets) {
            checkBonusNumber.add(lotto.compareLottoAndBonusNumbers(lottoMachine));
        }
        return checkBonusNumber;
    }


}
