package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

class LottoNumberTest {
    @Test
    @DisplayName("로또번호는 1부터 45 사이의 숫자만 포함한다.")
    void shouldContainNumbersBetween1And45Only() {
        final LottoNumber lottoNumber1 = new LottoNumber(1);
        final LottoNumber lottoNumber45 = new LottoNumber(45);

        assertAll(
            () -> assertThat(lottoNumber1).isEqualTo(new LottoNumber(1)),
            () -> assertThat(lottoNumber45).isEqualTo(new LottoNumber(45))
        );
    }

    @Test
    @DisplayName("로또번호는 1부터 45 사이가 아닌 숫자일 경우 예외가 발생한다.")
    void shouldThrowExceptionWhenNumberIsOutOfRange() {
        assertAll(
            () -> assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumber(0)),
            () -> assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumber(46))
        );
    }
}
