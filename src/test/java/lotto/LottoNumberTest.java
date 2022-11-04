package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {
    @Test
    @DisplayName("숫자 45")
    void test1() {
        // given
        // when
        LottoNumber lottoNumber = LottoNumber.of(45);
        // then
        assertThat(lottoNumber).isEqualTo(LottoNumber.of(45));
    }

    @Test
    @DisplayName("숫자 46")
    void test2() {
        // given
        // when
        // then
        assertThatThrownBy(() -> {
            LottoNumber.of(46);
        }).isInstanceOf(IllegalArgumentException.class);
    }

}
