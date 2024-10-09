package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoTicket {
    private static final int PRICE = 1000;

    private final List<Lotto> ticket;
    private final int totalLottoCount;

    public LottoTicket(final int purchasePrice) {
        this.ticket = new ArrayList<>();
        this.totalLottoCount = getTotalLottoCount(purchasePrice);
        issue();
    }

    private void issue() {
        for (int i = 0; i < totalLottoCount; i++) {
            ticket.add(new Lotto());
        }
    }

    private int getTotalLottoCount(final int purchasePrice) {
        validatePurchasePrice(purchasePrice);
        return purchasePrice / PRICE;
    }

    private void validatePurchasePrice(final int purchasePrice) {
        if (purchasePrice % PRICE != 0) {
            throw new IllegalArgumentException("올바른 구매금액이 아닙니다. 로또 개수에 맞게 금액을 넣어주세요.(1장당 1000원)");
        }
    }

    public LottoWinningResults getWinningResult(final Lotto winningLotto) {
        LottoWinningResults lottoWinningResults = new LottoWinningResults();
        ticket.forEach(lotto -> {
            int winningCount = lotto.getMatchingNumberCount(winningLotto);
            lottoWinningResults.incrementWinningResults(winningCount);
        });
        return lottoWinningResults;
    }

    public List<Lotto> getTicket() {
        return ticket;
    }
}
