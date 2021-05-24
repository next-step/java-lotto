package lotto.lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoTicket {
    private final List<Lotto> lottoTickets = new ArrayList<>();

    public void add(Lotto lotto) {
        lottoTickets.add(lotto);
    }

    public List<Lotto> tickets() {
        return lottoTickets;
    }

    public LottoResult matchWinningNumber(WinningNumber winningNumber) {
        LottoResult lottoResult = new LottoResult();
        lottoTickets.forEach(lotto -> {
            lotto.retainAll(winningNumber);
            lottoResult.increaseCount(lotto.answerCount());
        });
        return lottoResult;
    }

    public int matchingCount() {
        return lottoTickets.size();
    }
}
