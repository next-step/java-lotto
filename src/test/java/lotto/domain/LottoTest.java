package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoTest {

    @Test
    void 동일한번호_생성시_예외() {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new Lotto(new Integer[]{1, 2, 3, 3, 4, 5}));
    }



}