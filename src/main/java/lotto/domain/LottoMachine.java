package lotto.domain;

import java.util.List;

public class LottoMachine {
    public LottoTicket generateLottoTicket(int number) {
        LottoTicket lottoTicket = new LottoTicket(number);
        return lottoTicket;
    }
    public Rank rank(Lotto lotto, Lotto winningLotto) {
        int matchCount = lotto.match(winningLotto);
        return Rank.rank(matchCount);
    }
}
