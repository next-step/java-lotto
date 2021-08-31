package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LottoTicket {

    private final List<LottoNumbers> tickets = new ArrayList<>();

    public LottoTicket(final int ticketSize,
        final LottoNumberSelectPolicy lottoNumberSelectPolicy) {
        for (int i = 0; i < ticketSize; i++) {
            tickets.add(new LottoNumbers(lottoNumberSelectPolicy.selectNumbers()));
        }
    }

    public int size() {
        return tickets.size();
    }

    public List<LottoNumbers> getTickets() {
        return Collections.unmodifiableList(tickets);
    }

    public List<LottoRank> getLottoRanks(final WinningNumbers winningNumbers) {
        List<LottoRank> lottoRanks = new ArrayList<>();
        for (LottoNumbers lottoNumbers : tickets) {
            lottoRanks.add(LottoRank.findRank(winningNumbers.getMatchCount(lottoNumbers),
                winningNumbers.checkBonusNumber(lottoNumbers)));
        }
        return lottoRanks;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final LottoTicket that = (LottoTicket) o;
        return Objects.equals(tickets, that.tickets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tickets);
    }
}
