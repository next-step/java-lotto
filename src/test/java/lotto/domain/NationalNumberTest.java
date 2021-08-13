package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NationalNumberTest {
    @ParameterizedTest
    @DisplayName("자연수 입력 실패 테스트")
    @ValueSource(ints = {-1, -100, -1000})
    void 자연수_유효성검사_실패_테스트(int number) {
        assertThatThrownBy(() -> NationalNumber.validateStrNumber(Integer.toString(number)))
                .isInstanceOf(RuntimeException.class);
    }
}
