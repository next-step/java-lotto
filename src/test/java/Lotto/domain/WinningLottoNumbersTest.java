package Lotto.domain;

import Lotto.exception.WinningNumberWrongFormat;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WinningLottoNumbersTest {

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6", "1, 2, 3"})
    @DisplayName("당첨번호의 갯수나 형식이 맞지않으면 예외를 던진다")
    public void validateWinningLottoNumbersTest(String numbers) {
        Assertions.assertThrows(WinningNumberWrongFormat.class, (
        ) -> new WinningLottoNumbers(numbers));
    }
}