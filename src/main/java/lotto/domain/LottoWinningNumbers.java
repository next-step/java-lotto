package lotto.domain;

public class LottoWinningNumbers {
    private final LottoTicket winningNumbers;
    private final LottoNumber bonusNumber;

    public LottoWinningNumbers(LottoTicket winningNumbers, LottoNumber bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
        validateBonusNumber();
    }

    private void validateBonusNumber() {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    public int matchCount(LottoTicket lottoTicket) {
        return (int) lottoTicket.getLottoNumbers()
                                 .stream()
                                 .filter(winningNumbers::contains)
                                 .count();
    }

    public boolean hasBonus(LottoTicket lottoTicket) {
        return lottoTicket.contains(bonusNumber);
    }

    public LottoTicket getWinningNumbers() {
        return winningNumbers;
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }
}
