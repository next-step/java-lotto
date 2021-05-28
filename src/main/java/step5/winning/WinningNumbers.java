package step5.winning;

import step5.lotto.LottoNumber;
import step5.lotto.LottoTicket;
import step5.utils.ValidationUtils;

import java.util.List;
import java.util.Set;

public class WinningNumbers {
    private LottoTicket winningNumbers;

    public WinningNumbers(String inputWinningNumbers) {
        Set<Integer> winningNumbers = ValidationUtils.validWinningNumbers(inputWinningNumbers);
        this.winningNumbers = new LottoTicket(winningNumbers);
    }

    public List<LottoNumber> getWinningNumbers() {
        return this.winningNumbers.getLottoNumbers();
    }
}
