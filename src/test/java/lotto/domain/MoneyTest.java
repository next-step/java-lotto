package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MoneyTest {

    private static final int MINIMUM_MONEY = 1000;

    @ParameterizedTest
    @ValueSource(ints = {1000, 1001, 100000, 29302, 34809})
    void 유효한_금액을_입력했을_때(int input) {
        assertThat(input).isEqualTo(new Money(Integer.toString(input)).getMoney());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 0, -1, 999, 100})
    void 유요하지_않은_금액을_입력했을_때(int input) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new Money(Integer.toString(input)))
            .withMessage(
                "[ERROR] " + MINIMUM_MONEY + "원에 1장입니다. " + MINIMUM_MONEY + "보다 큰 값을 입력해주세요.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "1a", "sadjkfl", "--1df"})
    void 문자열을_int형으로_반환할_수_없다(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new Money(input))
            .withMessage("[ERROR] 숫자만 입력해주세요.");
    }
}
