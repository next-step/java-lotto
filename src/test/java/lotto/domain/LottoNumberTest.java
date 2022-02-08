package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumberTest {

    @DisplayName(value = "로또 번호는 1부터 45까지가 아니면 IllegalArgumentException이 발생한다.")
    @Test
    void invalidLottoNumber() {
        assertThatThrownBy(() -> new LottoNumber(50)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName(value = "로또 번호는 1~45까지이다")
    @Test
    void validInRange() {
        assertDoesNotThrow(() -> new LottoNumber(1));
        assertDoesNotThrow(() -> new LottoNumber(30));
        assertDoesNotThrow(() -> new LottoNumber(45));
        assertThatThrownBy(() -> new LottoNumber(100)).isInstanceOf(IllegalArgumentException.class);
    }
}
