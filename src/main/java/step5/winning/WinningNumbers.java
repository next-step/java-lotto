package step5.winning;

import step5.lotto.LottoNumber;
import step5.lotto.LottoTicket;
import step5.utils.StringUtils;
import step5.utils.ValidationUtils;
import java.util.List;
import java.util.Set;

public class WinningNumbers {
    private LottoTicket winningNumbers;
    private LottoNumber bonusNumber;

    public WinningNumbers(String inputWinningNumbers, int bonusNumber) {
        ValidationUtils.isNull(inputWinningNumbers);
        ValidationUtils.validWinningNumbersComma(inputWinningNumbers);
        Set<Integer> winningNumbers = StringUtils.processStringNumbers(inputWinningNumbers);
        ValidationUtils.validWinningNumbersDigit(winningNumbers.size());
        ValidationUtils.validDuplicationNumbers(winningNumbers, bonusNumber);

        this.winningNumbers = new LottoTicket(winningNumbers);
        this.bonusNumber = new LottoNumber(bonusNumber);
    }

    public List<LottoNumber> getWinningNumbers() {
        return this.winningNumbers.getLottoNumbers();
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }
}
