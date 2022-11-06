package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoStaticsTest {

    private static final List<Lotto> lottoList = null;

    @Test
    void test_Throw_IllegalArgumentException_If_lottoList_has_null() {
        assertThatThrownBy(() -> LottoStatics.calculate(lottoList))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
