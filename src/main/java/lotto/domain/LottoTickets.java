package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTickets {

    private final List<LottoNumbers> tickets = new ArrayList<>();

    public LottoTickets(final int ticketSize,
        final LottoNumberSelectPolicy lottoNumberSelectPolicy) {
        for (int i = 0; i < ticketSize; i++) {
            tickets.add(new LottoNumbers(lottoNumberSelectPolicy));
        }
    }

    public int size() {
        return tickets.size();
    }

    public List<LottoNumbers> getTickets() {
        return Collections.unmodifiableList(tickets);
    }

    public List<LottoRank> getLottoRanks(final LottoNumbers winningNumbers) {
        List<LottoRank> lottoRanks = new ArrayList<>();
        for (LottoNumbers lottoNumber : tickets) {
            lottoRanks.add(lottoNumber.checkRank(winningNumbers));
        }
        return lottoRanks;
    }
}
