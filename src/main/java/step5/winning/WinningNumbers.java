package step5.winning;

import step5.lotto.LottoNumber;
import step5.lotto.LottoTicket;
import step5.utils.StringUtils;
import step5.utils.ValidationUtils;
import java.util.Set;

public class WinningNumbers {
    private static final int DEFAULT_VALUE = 0;
    private static final int ONE_VALUE = 1;
    private LottoTicket winningNumbers;
    private LottoNumber bonusNumber;

    public WinningNumbers(String inputWinningNumbers, int bonusNumber) {
        ValidationUtils.isNull(inputWinningNumbers);
        ValidationUtils.validWinningNumbersComma(inputWinningNumbers);
        Set<Integer> winningNumbers = StringUtils.processStringNumbers(inputWinningNumbers);
        ValidationUtils.validWinningNumbersDigit(winningNumbers.size());
        ValidationUtils.validDuplicationNumbers(winningNumbers, bonusNumber);

        LottoTicket winningNumberTicket = new LottoTicket();
        winningNumberTicket.createManualLottoNumbers(winningNumbers);
        this.winningNumbers = winningNumberTicket;
        this.bonusNumber = new LottoNumber(bonusNumber);
    }

    public boolean hasBonusNumber(LottoTicket ticket) {
        if (ticket.containNumber(this.bonusNumber) == ONE_VALUE) {
            return true;
        }
        return false;
    }

    public int calculateWinningPoints(LottoTicket ticket) {
        int points = DEFAULT_VALUE;
        for (LottoNumber winningNumber: winningNumbers.getLottoNumbers()) {
            points += ticket.containNumber(winningNumber);
        }
        return points;
    }
}
