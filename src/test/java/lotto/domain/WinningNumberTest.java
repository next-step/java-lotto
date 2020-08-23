package lotto.domain;

import lotto.utils.LottoValidationUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static lotto.utils.LottoValidationUtils.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class WinningNumberTest {

    private WinningNumber winningNumber;
    private String inputWinnungNumber;
    private List<Integer> winningNumbers;
    private WinningResult winningResult;

    @BeforeEach
    void setUp() {
        inputWinnungNumber = "1, 2, 3, 4, 5, 6";
        winningNumber = new WinningNumber();
        winningResult = new WinningResult();
    }

    @Test
    @DisplayName("입력한 당첨번호 확인")
    void inputWinningNumber() {
        List<Integer> winningNumbers = winningNumber.setWinningNumber(inputWinnungNumber);
        assertThat(winningNumbers).contains(1, 2, 3, 4, 5, 6);
        assertThat(winningNumbers).hasSize(6);
    }

    @Test
    @DisplayName("입력한 당첨번호 중복 금지")
    void inputWinningNumberDistint() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    LottoValidationUtils.inputWinningNumberDuplicationException(new String[]{"1", "2", "3", "3", "4", "10"});
                }).withMessage(INVALID_DUPLICATION_NUMBER);
    }

    @Test
    @DisplayName("입력한 당첨 번호가 6개가 아니라면 Exception 발생")
    void invalidWinningNumber() {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> {
                    LottoValidationUtils.invalidWinningNumberSizeException(new String[]{"1", "2", "3"});
                }).withMessageMatching(INVALID_WINNING_NUMBER_SIZE);
    }

    @Test
    @DisplayName("입력한 당첨 번호가 1 ~ 45 이내의 숫자가 아니면 Exception 발생")
    void invalidWinningNumbers() {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> {
                    LottoValidationUtils.winningNumberRangeException(new String[]{"-1", "50", "46"});
                }).withMessageMatching(INVALID_LOTTO_NUMBER);
    }

    @Test
    @DisplayName("구입한 로또의 당첨번호 확인")
    void lottoWinningNumberCheck() {
        LottoTickets lottoTickets1 = new LottoTickets(Arrays.asList(1,2,3,4,5,6), 1);
        LottoTickets lottoTickets2 = new LottoTickets(Arrays.asList(1,2,3,4,11,23), 1);
        LottoTickets lottoTickets3 = new LottoTickets(Arrays.asList(11,15,21,25,35,36), 1);
        winningNumbers = winningNumber.setWinningNumber("1, 2, 3, 4, 5, 6");

        WinningResult result1 = winningResult.matchWinningNumber(winningNumbers, lottoTickets1);
        WinningResult result2 = winningResult.matchWinningNumber(winningNumbers, lottoTickets2);
        WinningResult result3 = winningResult.matchWinningNumber(winningNumbers, lottoTickets3);

        assertThat(result1.getWinningResult(Rank.FIRST)).isEqualTo(1);
        assertThat(result2.getWinningResult(Rank.THIRD)).isEqualTo(1);
        assertThat(result3.getWinningResult(Rank.LOSING)).isEqualTo(1);
    }

}
