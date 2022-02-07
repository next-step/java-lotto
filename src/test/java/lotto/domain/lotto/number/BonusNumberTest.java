package lotto.domain.lotto.number;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BonusNumberTest {

    private static final int MINIMUM_BALL_NUMBER = 1;
    private static final int MAXIMUM_BALL_NUMBER = 45;

    @DisplayName("범위 내로 유효하며 Numbers와 중복되지 않는 String값이 들어오는 경우")
    @ValueSource(strings = {"7", "8", "9", "45"})
    @ParameterizedTest
    void stringTest(String input) {
        final Numbers numbers = new Numbers(1, 2, 3, 4, 5, 6);
        assertThat(Integer.parseInt(input)).isEqualTo(new BonusNumber(input, numbers).getValue());
    }

    @DisplayName("범위 내로 유효하나 Numbers와 중복되는 String값이 들어오는 경우")
    @ValueSource(strings = {"1", "2", "3", "4", "5", "6"})
    @ParameterizedTest
    void invalidStringTest1(String input) {
        final Numbers numbers = new Numbers(1, 2, 3, 4, 5, 6);
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(
                () -> new BonusNumber(input, numbers))
            .withMessage("[ERROR] 당첨 번호와 중복된 값입니다. 다시 입력해주세요.");
    }

    @DisplayName("범위 밖의 정수 형태로 변환되는 String값이 들어오는 경우")
    @ValueSource(strings = {"0", "525", "53", "54", "55", "46"})
    @ParameterizedTest
    void invalidStringTest2(String input) {
        final Numbers numbers = new Numbers(1, 2, 3, 4, 5, 6);
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(
            () -> new BonusNumber(input, numbers)).withMessage(
            "[ERROR] " + MINIMUM_BALL_NUMBER + "부터 " + MAXIMUM_BALL_NUMBER + "까지의 숫자만 입력해주세요.");
    }
}