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
            // matchingCount로직에서 중복되는 번호만 남기기 때문에 보너스 번호가 있는지 먼저 검사해야함
            boolean containBonus = lotto.isContainBonus(bonusNumber);
            lottoResult.increaseCount(lotto.matchingCount(winningNumber), containBonus);
        });
        return lottoResult;
    }

    public int matchingCount() {
        return lottoTickets.size();
    }
}
