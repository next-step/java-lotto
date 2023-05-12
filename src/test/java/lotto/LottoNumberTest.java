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
                () -> assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumber(0)),
                () -> assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumber(46))
        );
    }

    @Test
    @DisplayName("같은지 확인한다")
    public void equals() {
        assertThat(new LottoNumber(3)).isEqualTo(new LottoNumber(3));
    }

    @Test
    @DisplayName("캐시를 이용한다")
    public void cache() {
        assertThat(LottoNumber.of(3) == LottoNumber.of(3)).isTrue();
    }
}
