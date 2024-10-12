package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTicket {
    private final List<Lotto> ticket;

    public LottoTicket(final LottoPurchasePrice purchasePrice) {
        this.ticket = new ArrayList<>();
        issue(purchasePrice.getLottoCount());
    }

    private void issue(int lottoCount) {
        for (int i = 0; i < lottoCount; i++) {
            ticket.add(new Lotto());
        }
    }

    public LottoWinningResults getWinningResult(final Lotto winningLotto) {
        LottoWinningResults lottoWinningResults = new LottoWinningResults();
        ticket.forEach(lotto -> {
            LottoMatchNumberInfo matchNumberInfo = lotto.getLottoMatchNumberInfo(winningLotto);
            lottoWinningResults.incrementWinningResults(matchNumberInfo);
        });
        return lottoWinningResults;
    }

    public List<Lotto> getTicket() {
        return Collections.unmodifiableList(ticket);
    }
}
