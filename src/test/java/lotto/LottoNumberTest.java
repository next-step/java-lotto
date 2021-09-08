package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoNumberTest {

    @Test
    @DisplayName("유효한 로또 번호 검사 테스트")
    void validLottoNumber() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new LottoNumber(0);
        });

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new LottoNumber(46);
        });
    }

    @Test
    @DisplayName("값을 제대로 반환하는지 테스트")
    void value() {
        assertThat(new LottoNumber(1).value()).isEqualTo(1);
    }

    @Test
    @DisplayName("값은 번호를 가진 객체를 동일한 객체로 보는지 테스트")
    void equal() {
        assertThat(new LottoNumber(1)).isEqualTo(new LottoNumber(1));
    }
}