package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class LottoNumberTest {

    @Test
    void 로또번호_생성_범위_테스트() {
        assertThatThrownBy(() -> new LottoNumber(46)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호_일치_테스트() {
        LottoNumber lottoNumber1 = new LottoNumber(1);
        LottoNumber lottoNumber2 = new LottoNumber(1);

        boolean match = lottoNumber1.equals(lottoNumber2);

        assertThat(match).isTrue();
    }

}
