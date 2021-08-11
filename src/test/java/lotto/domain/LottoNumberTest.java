package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("로또숫자 생성 테스트")
class LottoNumberTest {

    @Test
    @DisplayName("로또숫자가 최소값 보다 낮을 떄 예외처리")
    void lottoNumberLessThenMinimumException() {
        assertThatThrownBy(() -> new LottoNumber(LottoNumber.MIN_NUMBER - 1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("cannot be less than " + LottoNumber.MIN_NUMBER);
    }

    @Test
    @DisplayName("로또숫자가 최대값 보다 높을 떄 예외처리")
    void lottoNumberGreaterTHenMaximumException() {
        assertThatThrownBy(() -> new LottoNumber(LottoNumber.MAX_NUMBER + 1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("cannot be greater than " + LottoNumber.MAX_NUMBER);
    }
}

