package study.lotto.step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LottoNumberTest {
    @Test
    @DisplayName("범위(1 이상 45 이하의 정수)를 넘어서는 로또 번호 선택 시, IllegalArgumentException 예외 발생")
    void out_of_range_number_then_throw_IllegalArgumentException() {
        // given
        int outOfRangeNumber = 46;

        // when, then
        assertThatThrownBy(() -> LottoNumber.of(outOfRangeNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 1 이상 45 이하의 정수입니다: " + outOfRangeNumber);
    }

    @Test
    @DisplayName("LottoNumber 객체 캐싱 확인")
    void cache() {
        assertThat(LottoNumber.of(1)).isSameAs(LottoNumber.of(1));
        assertThat(LottoNumber.of(45)).isSameAs(LottoNumber.of(45));
    }
}