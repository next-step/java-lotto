package step3.winning;

import step3.lotto.LottoNumber;
import step3.lotto.LottoTicket;
import step3.utils.StringUtils;
import step3.utils.ValidationUtils;

import java.util.List;

public class WinningNumbers {
    private static final String WINNING_NUMBER_COMMA_EXCEPTION = "당첨번호는 쉼표(,)로 구분되어야합니다.";
    private static final String WINNING_NUMBER_NULL_EXCEPTION = "당첨번호를 입력해주세요.";
    private static final String WINNING_NUMBER_SIX_DIGIT_EXCEPTION = "당첨번호는 6자리 숫자로 구성되어야합니다.";

    private LottoTicket winningNumbers;

    public WinningNumbers(String inputWinningNumbers) {
        if (!ValidationUtils.isNullCheck(inputWinningNumbers)) {
            throw new RuntimeException(WINNING_NUMBER_NULL_EXCEPTION);
        }
        if (!ValidationUtils.validWinningNumbersComma(inputWinningNumbers)) {
            throw new RuntimeException(WINNING_NUMBER_COMMA_EXCEPTION);
        }
        List<Integer> winningNumbers = StringUtils.processStringNumbers(inputWinningNumbers);
        if (!ValidationUtils.validWinningNumbersDigit(winningNumbers.size())) {
            throw new RuntimeException(WINNING_NUMBER_SIX_DIGIT_EXCEPTION);
        }
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
