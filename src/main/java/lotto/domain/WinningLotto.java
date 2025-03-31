package lotto.domain;

import java.util.List;

public class WinningLotto {
    private final LottoTicket winningNumbers;
    private final LottoNumber bonusNumber;

    public WinningLotto(List<Integer> winningNumbers, int bonusNumber) {
        validateDuplicate(winningNumbers, bonusNumber);
        this.winningNumbers = new LottoTicket(winningNumbers);
        this.bonusNumber = new LottoNumber(bonusNumber);
    }

    private void validateDuplicate(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber))
            throw new IllegalArgumentException(String.format("bonus number(%d) should not be duplicate. (winning numbers: %s)", bonusNumber, winningNumbers));
    }

    public LottoRank rank(LottoTicket ticket) {
        return LottoRank.of(ticket.countMatchNumbers(winningNumbers), ticket.contains(bonusNumber));
    }

}
