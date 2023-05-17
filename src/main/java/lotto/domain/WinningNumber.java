package lotto.domain;

import java.util.List;

public class WinningNumber {
    private final LottoTicket winningNumbers;
    private final LottoNumber bonusNumber;

    public WinningNumber(List<Integer> numbers, Integer bonusNumber) {
        validateBonusNumber(numbers, bonusNumber);

        this.winningNumbers = LottoTicket.createLottoTicketByManual(numbers);
        this.bonusNumber = LottoNumber.of(bonusNumber);
    }

    private void validateBonusNumber(List<Integer> numbers, Integer bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호가 당첨 번호에 중복 입니다.");
        }
    }

    public int getMatchCount(LottoTicket lottoTicket) {
        return lottoTicket.getMatchCount(winningNumbers);
    }

    public boolean isBonusMatched(LottoTicket lottoTicket) {
        return lottoTicket.isMatched(bonusNumber);
    }
}
