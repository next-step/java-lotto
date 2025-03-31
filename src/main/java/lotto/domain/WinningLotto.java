package lotto.domain;

import java.util.List;

public class WinningLotto {
    private final LottoTicket winningNumbers;
    private final LottoNumber bonusNumber;

    public WinningLotto(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = new LottoTicket(winningNumbers);
        this.bonusNumber = new LottoNumber(bonusNumber);
    }

    public LottoRank rank(LottoTicket ticket) {
        return LottoRank.of(ticket.countMatchNumbers(winningNumbers), ticket.contains(bonusNumber));
    }

}
