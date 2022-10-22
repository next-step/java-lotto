package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoNumberTest {

    @Test
    void 로또_번호_생성_범위초과() {
        Assertions.assertThatThrownBy(() -> new LottoNumber(46))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
