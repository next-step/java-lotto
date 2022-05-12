package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

class LottoNumberTest {
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46, 47})
    void LottoNumber_숫자범위를_넘어선경우(int number) {
        assertThatThrownBy(() -> LottoNumber.create(number)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 40, 41, 42, 43, 44, 45})
    void LottoNumber_불변객체_인스턴스_캐싱(int number) {
        assertThat(LottoNumber.create(number)).isSameAs(LottoNumber.create(number));
    }
}
