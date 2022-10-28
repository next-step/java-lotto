package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoNumberTest {
    @Test
    @DisplayName("로또 번호 1 ~ 45 일경우 ")
    void 로또_번호_성공() {
        assertThat(new LottoNumber(1).getLottoNumber()).isEqualTo(1);
        assertThat(new LottoNumber(45).getLottoNumber()).isEqualTo(45);
    }

    @Test
    @DisplayName("로또 번호가 1보다 작거나, 45보다 크면 예외 발생")
    void 로또_번호_실패() {
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumber(48));
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumber(0));
    }
}
