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

    public LottoTicket(final LottoPurchasePrice purchasePrice, final List<Lotto> manualTicket) {
        int autoIssueCount = purchasePrice.getLottoCount() - manualTicket.size();
        if (autoIssueCount < 0) {
            throw new IllegalArgumentException("로또 구매 금액보다 많은 양의 수동 로또가 생성되었습니다.");
        }
        this.ticket = new ArrayList<>(manualTicket);
        issue(autoIssueCount);
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
