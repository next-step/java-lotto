package lotto.domain.numbers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {

    @DisplayName("인스턴스 캐싱 확인")
    @Test
    void create() {
        LottoNumber lottoNumber = LottoNumber.of(1);
        assertThat(LottoNumber.of(1)).isEqualTo(lottoNumber);
        assertThat(LottoNumber.of(1) == lottoNumber).isTrue();
    }

    @DisplayName("숫자가 1부터 45 사이에 속하지 않을 경우 Exception 발생")
    @ParameterizedTest
    @ValueSource(ints = {46, 47, 0})
    void LottoNumber_not_range(int number) {
        assertThatThrownBy(() -> LottoNumber.of(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자는 1부터 45까지여야 합니다.");
    }
}
