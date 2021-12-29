package lotto.domain;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberTest {

    @DisplayName("1에서 45사이 이외의 숫자를 선택할 수 없다.")
    @ParameterizedTest
    @ValueSource(ints = {-100, -1, 0, 46, 50, 100})
    void createFail(int value) {
        // when
        ThrowableAssert.ThrowingCallable callable = () -> LottoNumber.from(value);

        // then
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(callable)
                .withMessageMatching("1에서 45사이의 숫자만 선택할 수 있습니다.");
    }
}
