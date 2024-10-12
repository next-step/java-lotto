package lotto.domain.number;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoNumberTest {

    @Test
    void 숫자_1_45_사이로_인스턴스_정상_생성() {
        assertThat(new LottoNumber(25).number()).isEqualTo(25);
        assertThat(new LottoNumber(1).number()).isEqualTo(1);
        assertThat(new LottoNumber(45).number()).isEqualTo(45);
    }

    @Test
    void 숫자_1_45_사이_아니면_인스턴스_생성시_예외발생() {
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumber(0));
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumber(46));
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumber(-1));
    }
}
