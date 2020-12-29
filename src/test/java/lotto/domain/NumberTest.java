package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class NumberTest {
    private Number number;


    @ParameterizedTest
    @ValueSource(ints = {0,46})
    @DisplayName("1~45 번호 인지 체크")
    void validateNumber(Integer inputInt) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Number(inputInt);
        });
    }
}
