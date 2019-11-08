package step2.Model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class WinningLottoGameTest {
    @ParameterizedTest
    @CsvSource(value = {
            "1, 1, 2, 3, 4, 5",
            "1, 2, 3, 4, 5",
            "0, 1, 2, 3, 4, 5",
    }, delimiter = ':')
    @DisplayName("에러 발생 테스트")
    void InvalidNumbersTest(String inputWinningNumbers) {
        assertThrows(IllegalArgumentException.class, () -> new WinningLotto(inputWinningNumbers));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1, 2, 3, 4, 5, 6:true",
            "2, 3, 4, 5, 6, 7:false",
            "1, 2, 3, 4, 5, 6:true",
            "2, 3, 4, 5, 6, 7:false"
    }, delimiter = ':')
    @DisplayName("당첨번호를 포함하는지 테스트")
    void containsTest(String inputWinningNumbers, boolean contains) {
        WinningLotto winningLotto = new WinningLotto(inputWinningNumbers);
        assertThat(winningLotto.contains(1)).isEqualTo(contains);
    }
}