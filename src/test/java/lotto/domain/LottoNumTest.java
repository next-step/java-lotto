package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoNumTest {
    @Test
    void createLottoNum() {
        Assertions.assertThat(new LottoNum(1)).isEqualToComparingFieldByField(new LottoNum(1));
    }

    @Test
    void getLottoNumVaild() {
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    LottoNum lottoNum = new LottoNum(46);
                });
    }
}