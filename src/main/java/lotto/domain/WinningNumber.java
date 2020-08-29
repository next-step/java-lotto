package lotto.domain;

public class WinningNumber {

    private LottoTicket winningNumbers;
    private BonusNumber bonusNumber;

    public WinningNumber(LottoTicket winningNumbers, BonusNumber bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public boolean isContainsLottoNumber(int lottoNumber) {
        return winningNumbers.getLottoTicket().contains(lottoNumber);
    }

    public int getBonusNumber() {
        return bonusNumber.getBonusNumber();
    }

}
