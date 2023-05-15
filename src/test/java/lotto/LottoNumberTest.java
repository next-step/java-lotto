package lotto;

import lotto.domain.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberTest {
    @Test
    @DisplayName("로또 번호는 1이상 45이하여야 한다")
    public void invalidNumbers() {
        assertAll(
                () -> assertThatIllegalArgumentException().isThrownBy(() -> LottoNumber.of(0)),
                () -> assertThatIllegalArgumentException().isThrownBy(() -> LottoNumber.of(46))
        );
    }

    @Test
    @DisplayName("캐시를 이용한다")
    public void cache() {
        assertThat(LottoNumber.of(3) == LottoNumber.of(3)).isTrue();
    }
}
