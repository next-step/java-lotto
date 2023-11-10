package lotto.validate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class NumberValidationTest {

    private NumberValidation numberValidation;

    @BeforeEach
    void setUp() {
        numberValidation = new NumberValidation();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void 로또_번호_유효성_검사_성공(int number) {
        // given
        // when
        numberValidation.checkNumberRange(number);
        // then
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 46, 47, 48, 49, 50})
    void 로또_번호_유효성_검사_실패(int number) {
        // given
        // when
        // then
        assertThatIllegalArgumentException().isThrownBy(() -> {
            numberValidation.checkNumberRange(number);
        }).withMessageMatching("로또 번호는 1부터 45까지의 숫자만 가능합니다.");
    }
}
