package lotto.domain;

public class WinningNumber {

    private LottoTicket winningNumbers;
    private int bonusNumber;

    public WinningNumber(LottoTicket winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public boolean isContainsLottoNumber(int lottoNumber) {
        return winningNumbers.getLottoTicket().contains(lottoNumber);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

}
