package lotto.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class InputValidatorTest {

    private static final String REGEX_DELIMITER_DEFAULT = ",";

    @Nested
    @DisplayName("로또 구매 입력값 validate 테스트")
    class ValidateBuyLottoInputTest {

        @DisplayName("숫자가 아닌 경우 에러")
        @ParameterizedTest
        @ValueSource(strings = {"A", "one"})
        void validate1(String input) {
            assertThatIllegalArgumentException().isThrownBy(() -> {
                InputValidator.validateParseInt(input);
            });
        }

        @DisplayName("빈값이거나 null이면 에러")
        @ParameterizedTest
        @NullAndEmptySource
        void validate2(String input) {
            assertThatIllegalArgumentException().isThrownBy(() -> {
                InputValidator.validateParseInt(input);
            });
        }

        @DisplayName("음수거나 0인 경우 에러")
        @ParameterizedTest
        @ValueSource(ints = {0, -144})
        void validate3(int input) {
            assertThatIllegalArgumentException().isThrownBy(() -> {
                InputValidator.validateMoreThanZero(input);
            });
        }

        @DisplayName("1000원으로 떨어지지 않는 경우 에러")
        @ParameterizedTest
        @ValueSource(ints = {1100, 5129})
        void validate4(int input) {
            assertThatIllegalArgumentException().isThrownBy(() -> {
                InputValidator.validateMultiple1000(input);
            });
        }

        @DisplayName("테스트 성공")
        @ParameterizedTest
        @CsvSource(value = {
                "1000, 0",
                "5000, 2",
                "18000, 1"
        })
        void validate5(String amount, String matchCount) {
            InputValidator.validateBuyLotto(amount, matchCount);
        }
    }


    @Nested
    @DisplayName("로또 당첨번호 입력값 validate 테스트")
    class ValidateAnnounceWinningInputTest {

        @DisplayName("빈값이거나 null이면 에러")
        @ParameterizedTest
        @NullAndEmptySource
        void validate1(String input) {
            assertThatIllegalArgumentException().isThrownBy(() -> {
                InputValidator.validateNotEmpty(input);
            });
        }

        @DisplayName("입력값이 6개가 아닌 경우 에러")
        @ParameterizedTest
        @ValueSource(strings = {"1,2,3", "1,1,2,3,4,5", "1,2,3,4,5,6,7,8"})
        void validate3(String input) {
            String[] inputs = input.split(REGEX_DELIMITER_DEFAULT);

            assertThatIllegalArgumentException().isThrownBy(() -> {
                InputValidator.validateSize(inputs);
            });
        }

        @DisplayName("입력값 중 45번을 넘는 수가 있다면 에러")
        @ParameterizedTest
        @ValueSource(strings = {"1,2,3,4,5,61"})
        void validate4(String input) {
            String[] inputs = input.split(REGEX_DELIMITER_DEFAULT);

            assertThatIllegalArgumentException().isThrownBy(() -> {
                InputValidator.validateOverMaxNum(inputs);
            });
        }

        @DisplayName("보너스값 유효한지 체크")
        @ParameterizedTest
        @ValueSource(strings = {"-1", "0", "46", "60"})
        void validate5(String bonus) {
            assertThatIllegalArgumentException().isThrownBy(() -> {
                InputValidator.validNumberRange(bonus);
            });
        }

        @DisplayName("보너스값이 당첨번호에 속한다면 에러")
        @ParameterizedTest
        @CsvSource(value = {
                "1,2,3,4,5,6 | 6"
        }, delimiter = '|')
        void validate6(String input, String bonus) {
            String[] inputs = input.split(REGEX_DELIMITER_DEFAULT);

            assertThatIllegalArgumentException().isThrownBy(() -> {
                InputValidator.validateBonusNotInWinning(inputs, bonus);
            });
        }

        @DisplayName("테스트 성공")
        @ParameterizedTest
        @CsvSource(value = {
                "1,2,3,4,5,6 | 7"
        }, delimiter = '|')
        void validate7(String input, String bonus) {
            InputValidator.validateWinning(input, bonus);
        }
    }
}
