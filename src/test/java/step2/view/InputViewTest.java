package step2.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class InputViewTest {
    @DisplayName("금액 유효성 검사 : 1000원 이상")
    @ParameterizedTest
    @MethodSource("inputMoney")
    void validInputMoney(boolean expect, int money) {
        assertThat(InputView.isValidateMoney(money)).isEqualTo(expect);
    }

    private static Stream<Arguments> inputMoney() {
        return Stream.of(
                Arguments.of(true, 900),
                Arguments.of(false, 1000)
        );
    }

    @DisplayName("지난 주 당첨 번호 유효성 검사 : 1~45")
    @ParameterizedTest
    @MethodSource("inputWinningNumbers")
    void validInputWinningNumbers(boolean expect, String number) {
        String[] numbers = InputView.splitWinningLottoNumber(number);
        assertThat(InputView.isValidateWinningLottoNumber(numbers)).isEqualTo(expect);
    }

    private static Stream<Arguments> inputWinningNumbers() {
        return Stream.of(
                Arguments.of(true, "0,1,2,3,4,5"),
                Arguments.of(true, "41,42,43,44,45,46"),
                Arguments.of(false, "1,2,3,4,5,6"),
                Arguments.of(false, "40,41,42,43,44,45")
        );
    }

    @DisplayName("지난 주 당첨 번호 유효성 검사 : 6개 이상")
    @ParameterizedTest
    @MethodSource("inputWinningNumbersSize")
    void validInputWinningNumbersSize(boolean expect, String number) {
        String[] numbers = InputView.splitWinningLottoNumber(number);
        assertThat(InputView.isValidateWinningLottoNumberSize(numbers)).isEqualTo(expect);
    }

    private static Stream<Arguments> inputWinningNumbersSize() {
        return Stream.of(
                Arguments.of(true, "1,2,3,4,5,6,7"),
                Arguments.of(false, "40,41,42,43,44,45")
        );
    }

    @DisplayName("지난 주 당첨 번호 유효성 검사 : 6개 이상")
    @ParameterizedTest
    @ValueSource(strings = "1,2,3,4,5,6")
    void splitLottoNumber(String lottoNumber) {
        String[] splitLottoNumbers = InputView.splitWinningLottoNumber(lottoNumber);
        assertThat(splitLottoNumbers).isEqualTo(new String[]{"1", "2", "3", "4", "5", "6"});
    }

    @DisplayName("지난 주 당첨 번호 유효성 검사 : 중복 숫자")
    @ParameterizedTest
    @MethodSource("inputDuplicatedWinningNumbers")
    void validDuplicatedWinningNumbers(boolean expect, String[] number) {
        assertThat(InputView.isValidateDuplicatedWinningLottoNumber(number)).isEqualTo(expect);
    }

    private static Stream<Arguments> inputDuplicatedWinningNumbers() {
        return Stream.of(
                Arguments.of(true, new String[]{"20", "20", "21", "22", "23", "24"}),
                Arguments.of(false, new String[]{"19", "20", "21", "22", "23", "24"})
        );
    }
}
