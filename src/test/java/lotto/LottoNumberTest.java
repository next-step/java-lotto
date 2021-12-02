package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoNumberTest {
    @Test
    void create() {
        LottoNumber lottoNumber = new LottoNumber(1);
        assertThat(lottoNumber).isEqualTo(new LottoNumber(1));
    }

    @Test
    @DisplayName("로또의 숫자 범위는 1~45 이다.")
    void lottoNumberRange() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new LottoNumber(0);
        });

        new LottoNumber(1);
        new LottoNumber(45);

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new LottoNumber(46);
        });
    }
}
