package lotto;

import java.util.List;

public class WinningLotto {
    private List<LottoNumber> winningNumbers;
    private LottoNumber bonusNumber;

    public WinningLotto(List<LottoNumber> winningNumbers, LottoNumber bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public int getWinningCount(LottoTicket lottoTicket) {
        return (int) winningNumbers.stream()
                .filter(lottoTicket::compareWinningNumber).count();
    }

    public boolean isWinningBonusNumber(LottoTicket lottoTicket) {
        return lottoTicket.compareBonusBall(bonusNumber);
    }
}
