package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.LottoNumber;
import org.junit.jupiter.api.Test;

public class LottoNumberTest {

    @Test
    void testInvalidLottoNumber() {
        assertThatThrownBy(() -> new LottoNumber(47))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("유효하지 않은 로또 번호 입니다.");
    }

    @Test
    void testLottoNumberEquals() {
        assertThat(new LottoNumber(10)).isEqualTo(new LottoNumber(10));
    }

}
