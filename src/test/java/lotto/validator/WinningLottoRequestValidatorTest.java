package lotto.validator;

import lotto.models.request.WinningLottoRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class WinningLottoRequestValidatorTest {
    private static final String STRING_NUMBER_WRONG_CHARACTER = "문자열로 입력된 로또 번호는 숫자, 공백, 콤마(,)만을 포함해야합니다.";
    private static final String WRONG_BONUS_NUMBER = "로또 번호는 반드시 1~45의 값 입니다.";

    private static final String DUPLICATED_BONUS_NUMBER = "보너스 번호와 로또 번호는 중복되지 않아야합니다.";

    @ParameterizedTest
    @DisplayName("당첨 번호가 숫자, 공백, 콤마 외의 기호를 포함할 경우 Exception을 발생시킨다.")
    @ValueSource(strings = {"1, 2, 3; 4, 5, 6", "1, 2, 3, 4, a, 5", "1, 2, 3, *. 5, 6"})
    void exceptionTest1(String numbers) {
        WinningLottoRequest winningLottoRequest = WinningLottoRequest.of(numbers, 10);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> WinningLottoRequestValidator.validate(winningLottoRequest));
        assertThat(exception.getMessage()).isEqualTo(STRING_NUMBER_WRONG_CHARACTER);
    }

    @ParameterizedTest
    @DisplayName("보너스 번호가 1~45의 범위를 벗어난 경우 Exception을 발생시킨다.")
    @ValueSource(ints = {0, 46, -10})
    void exceptionTest2(int bonusNumber) {
        WinningLottoRequest winningLottoRequest = WinningLottoRequest.of("1, 2, 3, 4, 5, 6", bonusNumber);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> WinningLottoRequestValidator.validate(winningLottoRequest));
        assertThat(exception.getMessage()).isEqualTo(WRONG_BONUS_NUMBER);
    }

    @Test
    @DisplayName("보너스 번호가 먼저 입력된 로또 번호와 중복되면 Exception을 발생시킨다.")
    void exceptionTest3() {
        WinningLottoRequest winningLottoRequest = WinningLottoRequest.of("1, 2, 3, 4, 5, 6", 6);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> WinningLottoRequestValidator.validate(winningLottoRequest));
        assertThat(exception.getMessage()).isEqualTo(DUPLICATED_BONUS_NUMBER);
    }
}
