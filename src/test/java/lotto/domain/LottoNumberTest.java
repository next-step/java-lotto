package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoNumberTest {
    @Test
    @DisplayName("로또 번호가 1보다 작거나, 45보다 크면 예외 발생")
    void 로또_번호_확인() {
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumber(48));
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumber(0));
    }
}
