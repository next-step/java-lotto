package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoNumberTest {
    @Test
    void 로또_번호_생성_테스트() {
        assertThat(new LottoNumber(2)).isEqualTo(new LottoNumber(2));
    }

    @Test
    void 로또_번호_범위_테스트() {
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumber(46));
    }
}
