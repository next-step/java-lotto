package lotto.validate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class NumberValidationTest {

    private NumberValidation numberValidation;

    @BeforeEach
    void setUp() {
        numberValidation = new NumberValidation();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void 로또_번호_유효성_검사(int number) {
        // given
        // when
        boolean check = numberValidation.checkNumberRange(number);
        // then
    }
}
