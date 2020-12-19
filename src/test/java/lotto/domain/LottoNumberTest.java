package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoNumberTest {

    @Test
    @DisplayName("1에서 45사이의 로또번호 반환")
    void testGetLottoNumberInRange() {
        int number = 1;
        assertThat(LottoNumber.of(number).getValue()).isEqualTo(number);
    }

    @Test
    @DisplayName("1에서 45사이의 로또번호가 아닐 경우 예외 발생")
    void testGetLottoNumberOutOfRange() {
        int number = 46;
        assertThatIllegalArgumentException().isThrownBy(() -> LottoNumber.of(number));
    }
}
