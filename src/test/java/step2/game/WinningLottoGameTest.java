package step2.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step2.numbers.Number;
import step2.numbers.WinningLotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class WinningLottoGameTest {
    @ParameterizedTest
    @CsvSource(value = {
            "1, 1, 2, 3, 4, 5:6",
            "1, 2, 3, 4, 5:6",
            "0, 1, 2, 3, 4, 5:6",
            "1, 2, 3, 4, 5, 46:6",
            "1, 2, 3, 4, 5, 6:6"
    }, delimiter = ':')
    @DisplayName("에러 발생 테스트")
    void invalidNumbersTest(String inputWinningNumbers, int bonusNumber) {
        assertThrows(IllegalArgumentException.class, () -> new WinningLotto(inputWinningNumbers, bonusNumber));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1, 2, 3, 4, 5, 6:10:true",
            "2, 3, 4, 5, 6, 7:10:false",
            "2, 3, 4, 5, 6, 7:10:false",
            "1, 2, 3, 4, 5, 6:10:true",
            "2, 3, 4, 5, 6, 7:1:false"
    }, delimiter = ':')
    @DisplayName("당첨번호를 포함하는지 테스트")
    void containsTest(String inputWinningNumbers, int bonusNumber, boolean contains) {
        WinningLotto winningLotto = new WinningLotto(inputWinningNumbers, bonusNumber);
        assertThat(winningLotto.contains(Number.valueOf(1))).isEqualTo(contains);
    }
}