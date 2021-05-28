package step5.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.Set;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;


class ValidationUtilsTest {
    @DisplayName("입력받은 당첨번호 null 체크")
    @ParameterizedTest
    @NullAndEmptySource
    void isNullCheck(String input) {
        assertThatThrownBy(() -> {
            ValidationUtils.isNull(input);
        }).isInstanceOf(RuntimeException.class)
                .hasMessageContaining("당첨번호를 입력해주세요.");
    }

    @DisplayName("입력받은 문자열이 쉼표로 구분되는지 확인")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3 4,5.6", "1:2:3:4:5,6", "1 2 3 4 5,8"})
    void validWinningNumbersComma(String input) {
        assertThatThrownBy(() -> {
            ValidationUtils.validWinningNumbersComma(input);
        }).isInstanceOf(RuntimeException.class)
                .hasMessageContaining("당첨번호는 쉼표(,)로 구분되어야합니다.");
    }

    @DisplayName("입력받은 size가 6자리인지 확인")
    @ParameterizedTest
    @ValueSource(strings = {"7", "0", "3"})
    void validWinningNumbersDigit(int size) {
        assertThatThrownBy(() -> {
            ValidationUtils.validWinningNumbersDigit(size);
        }).isInstanceOf(RuntimeException.class)
                .hasMessageContaining("당첨번호는 6자리 숫자로 구성되어야합니다.");
    }

    @DisplayName("당첨번호와 보너스번호 중복 확인")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:4", "10,15,23,24,25,30:30", "30,35,37,40,41,45:35"}, delimiter = ':')
    void validDuplicationNumbers(String inputNumbers, int bonusNumber) {
        Set<Integer> winningNumbers = StringUtils.processStringNumbers(inputNumbers);
        assertThatThrownBy(() -> {
            ValidationUtils.validDuplicationNumbers(winningNumbers, bonusNumber);
        }).isInstanceOf(RuntimeException.class)
                .hasMessageContaining("보너스볼은 당첨번호와 중복되서는 안됩니다.");
    }
}