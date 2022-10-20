package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {
    @Test
    @DisplayName("LottoNumber 에 int 값을 넣어 LottoNumber 를 생성한다.")
    void createLottoNumber_isEqualTo() {
        assertThat(new LottoNumber(1).getNumber()).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46, 100})
    @DisplayName("로또 숫자는 1 ~ 45 이다. 그 이외의 숫자는 IllegalArgumentException 이다.")
    void lottoNumberBoundTest_ThrowsException(int input) {
        assertThatThrownBy(() -> new LottoNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("of 메서드로 LottoNumber 가 생성된다.")
    void ofMethodTest_isEqualTo() {
        assertThat(LottoNumber.of(45)).isEqualTo(new LottoNumber(45));
    }
}
