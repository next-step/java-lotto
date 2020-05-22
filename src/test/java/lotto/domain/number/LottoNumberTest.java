package lotto.domain.number;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class LottoNumberTest {

    @DisplayName("1 ~ 45 범위 이외의 값이면 예외 발생")
    @ParameterizedTest
    @ValueSource(ints = { -1, LottoNumber.MIN_VALUE - 1, LottoNumber.MAX_VALUE + 1, 1000 })
    void createFail(final int number) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> LottoNumber.of(number));
    }

    @DisplayName("1 ~ 45 범위 값이 들어오면 LottoNumber 객체를 생성")
    @ParameterizedTest
    @ValueSource(ints = { LottoNumber.MIN_VALUE, 10, LottoNumber.MAX_VALUE })
    void create(final int number) {
        assertThatCode(() -> LottoNumber.of(number))
                .doesNotThrowAnyException();
    }

    @DisplayName("재정의한 equals 테스트")
    @Test
    void equals() {
        assertThat(LottoNumber.of(1).equals(LottoNumber.of(1))).isTrue();
        assertThat(LottoNumber.of(1).equals(LottoNumber.of(2))).isFalse();
    }
}
