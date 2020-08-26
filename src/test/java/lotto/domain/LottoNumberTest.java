package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {

    @DisplayName("로또 번호 생성 테스트")
    @Test
    void getLottoNumber() {
        assertThat(LottoNumber.of(8)).isEqualTo(LottoNumber.of(8));
    }

    @DisplayName("로또 1보다 작은 값 테스트")
    @Test
    void shouldExceptionLottoNumberlessThan_1() {
        assertThatThrownBy(() -> LottoNumber.of(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("유효한 로또 번호가 아닙니다.");
    }

    @DisplayName("로또 45보다 큰 값 테스트")
    @Test
    void shouldExceptionLottoNumberGreaterThan_45() {
        assertThatThrownBy(() -> LottoNumber.of(98))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("유효한 로또 번호가 아닙니다.");
    }
}
