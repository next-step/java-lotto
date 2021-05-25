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

    public LottoResult matchWinningNumber(WinningNumber winningNumber, LottoNumber bonusNumber) {
        LottoResult lottoResult = new LottoResult();
        lottoTickets.forEach(lotto -> {
            lottoResult.increaseCount(lotto.matchingCount(winningNumber), lotto.isContainBonus(bonusNumber));
        });
        return lottoResult;
    }

    public int matchingCount() {
        return lottoTickets.size();
    }
}
