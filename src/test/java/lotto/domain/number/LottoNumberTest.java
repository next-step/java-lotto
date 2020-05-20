package lotto.domain.number;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoNumberTest {

    @DisplayName("1 ~ 45 범위 이외의 값이면 예외 발생")
    @ParameterizedTest
    @ValueSource(ints = { -1, 0, 46, 1000 })
    void createFail(final int number) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> LottoNumber.of(number));
    }

    @DisplayName("1 ~ 45 범위 값이 들어오면 LottoNumber 객체를 생성")
    @ParameterizedTest
    @ValueSource(ints = { 1, 10, 45 })
    void create(final int number) {
        assertThatCode(() -> LottoNumber.of(number))
                .doesNotThrowAnyException();
    }
}
