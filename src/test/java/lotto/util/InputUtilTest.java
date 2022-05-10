package lotto.util;

import lotto.domain.LottoNumber;
import lotto.exception.InvalidInputLottoNumberException;
import lotto.exception.InvalidLottoNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputUtilTest {

    @ParameterizedTest
    @ValueSource(strings = {"0", "10", "1000"})
    @DisplayName("입력된 문자열을 BigDecimal 로 변환")
    void convertToBigDecimalTest(String input) {
        BigDecimal bigDecimal = InputUtil.readMoney(input);
        assertThat(bigDecimal).isEqualTo(new BigDecimal(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc", "1.1", "!"})
    @DisplayName("숫자가 아닌 문자열 입력 시 NumberFormatException 발생")
    void throwNumberFormatExceptionTest(String input) {
        assertThatThrownBy(() -> InputUtil.readMoney(input))
                .isInstanceOf(NumberFormatException.class)
                .hasMessageContaining("구매 금액을 제대로");
    }

    @Test
    @DisplayName("쉼표와 공백을 기준으로 숫자 배열 생성")
    void returnListByDelimiterAndBlank() {
        String input = "1, 2, 3, 4, 5, 6";
        Set<LottoNumber> integers = InputUtil.readLottoNumbers(input);
        assertThat(integers)
                .hasSize(6)
                .containsExactly(
                        new LottoNumber(1),
                        new LottoNumber(2),
                        new LottoNumber(3),
                        new LottoNumber(4),
                        new LottoNumber(5),
                        new LottoNumber(6)
                );
    }

    @ParameterizedTest
    @ValueSource(strings = {"1, 2, 3", "1, 2, 3, 4, 5, 6, 7", "1,2,3"})
    @DisplayName("입력된 숫자가 6개가 아닐 시에 InvalidInputLottoNumberException 발생")
    void throwInvalidInputLottoNumberExceptionTest(String input) {
        assertThatThrownBy(() -> InputUtil.readLottoNumbers(input))
                .isInstanceOf(InvalidInputLottoNumberException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"!, @, #, $, %, ^", "a, b, c, d, e, f", "1, 2, #"})
    @DisplayName("당첨번호에 숫자가 아닌 값을 입력 시 NumberFormatException 발생")
    void throwNumberFormatExceptionTestLottoNumber(String input) {
        assertThatThrownBy(() -> InputUtil.readLottoNumbers(input))
                .isInstanceOf(NumberFormatException.class)
                .hasMessageContaining("숫자를 입력해주세요.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "40", "10"})
    @DisplayName("보너스 번호 입력 시 Integer 로 반환")
    void convertBonusNumberToInteger(String input) {
        LottoNumber lottoNumber = InputUtil.readBonusNumber(input);
        assertThat(lottoNumber).isEqualTo(new LottoNumber(Integer.parseInt(input)));
    }

    @ParameterizedTest
    @ValueSource(strings = {"100", "0", "-1"})
    @DisplayName("1-45 를 벗어난 숫자 입력시 InvalidLottoNumberException 발생")
    void throwInvalidLottoNumberExceptionTest(String input) {
        assertThatThrownBy(() -> InputUtil.readLottoNumbers(input))
                .isInstanceOf(InvalidLottoNumberException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"!", "a", "1.1"})
    @DisplayName("보너스 번호를 정수로 입력하지 않으면 NumberFormatException 발생")
    void throwNumberFormatExceptionBonusNumber(String input) {
        assertThatThrownBy(() -> InputUtil.readBonusNumber(input))
                .isInstanceOf(NumberFormatException.class)
                .hasMessageContaining("숫자를 입력해주세요.");
    }
}