package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoNumberTest {
    @Test
    @DisplayName("로또의 숫자 범위는 1~45 이다. (올바른 경계값 테스트)")
    void lottoNumberRange() {
        LottoNumber lottoNumber1 = new LottoNumber(1);
        assertThat(lottoNumber1).isEqualTo(new LottoNumber(1));

        LottoNumber lottoNumber45 = new LottoNumber(45);
        assertThat(lottoNumber45).isEqualTo(new LottoNumber(45));
    }

    @Test
    @DisplayName("로또의 숫자 범위는 1~45 이다. (잘못된 경계값 테스트)")
    void lottoNumberInvalidNumber() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new LottoNumber(0);
        });

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new LottoNumber(46);
        });
    }
}
