package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.domain.LottoNumbers.INVALID_LOTTO_NUMBER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

class WinningNumberTest {

    private WinningNumber winningNumber;
    String inputWinnungNumber;

    @BeforeEach
    void setUp() {
        winningNumber = new WinningNumber();
        inputWinnungNumber = "1, 2, 3, 4, 5, 6";
    }

    @Test
    @DisplayName("입력한 당첨번호 확인")
    void inputWinningNumber() {
        String[] winningNumbers = winningNumber.setWinningNumber(inputWinnungNumber);
        assertThat(winningNumbers).contains("1","2","3","4","5","6");
    }

    @Test
    @DisplayName("입력한 당첨번호 사이즈가 6인지 확인")
    void winningNumbersSize() {
        String[] winningNumbers = winningNumber.setWinningNumber(inputWinnungNumber);
        assertThat(winningNumbers).hasSize(6);
    }

    @Test
    @DisplayName("입력한 당첨 번호가 6개가 아니라면 Exception 발생")
    void invalidWinningNumber() {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> {
                    winningNumber.invalidWinningNumberSizeException(new String[]{"1", "2", "3"});
                }).withMessageMatching(WinningNumber.INVALID_WINNING_NUMBER_SIZE);
    }

    @Test
    @DisplayName("입력한 당첨 번호가 1 ~ 45 이내의 숫자가 아니면 Exception 발생")
    void invalidWinningNumbers() {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> {
                    winningNumber.winningNumberRangeException(new String[]{"-1", "50", "46"});
                }).withMessageMatching(INVALID_LOTTO_NUMBER);
    }
}
