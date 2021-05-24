package step3.winning;

import step3.lotto.LottoNumber;
import step3.lotto.LottoTicket;
import step3.utils.ValidationUtils;
import java.util.List;

public class WinningNumbers {
    private LottoTicket winningNumbers;

    public WinningNumbers(String inputWinningNumbers) {
        List<Integer> winningNumbers = ValidationUtils.validWinningNumbers(inputWinningNumbers);
        this.winningNumbers = new LottoTicket(winningNumbers);
    }

    public List<Integer> getWinningNumbers() {
        return this.winningNumbers.getLottoNumbers();
    }

    public int isContainNumber(LottoNumber number) {
        if (getWinningNumbers().contains(number.getLottoNumber())) {
            return 1;
        }
        return 0;
    }
}
