package lotto.domain.number;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoNumberTest {

    @Test
    void 로또_번호_1_45_사이_숫자() {
        assertThat(LottoNumber.of(25).number()).isEqualTo(25);
        assertThat(LottoNumber.of(1).number()).isEqualTo(1);
        assertThat(LottoNumber.of(45).number()).isEqualTo(45);
        assertThatIllegalArgumentException().isThrownBy(() -> LottoNumber.of(0));
        assertThatIllegalArgumentException().isThrownBy(() -> LottoNumber.of(46));
        assertThatIllegalArgumentException().isThrownBy(() -> LottoNumber.of(-1));
    }

    @Test
    void 로또_번호_1_45_사이_숫자_아님() {
        assertThatIllegalArgumentException().isThrownBy(() -> LottoNumber.of(0));
        assertThatIllegalArgumentException().isThrownBy(() -> LottoNumber.of(46));
        assertThatIllegalArgumentException().isThrownBy(() -> LottoNumber.of(-1));
    }
}
