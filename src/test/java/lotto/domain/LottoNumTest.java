package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoNumTest {
    LottoNum lottoNum;

    @BeforeEach
    void create() {
        lottoNum = new LottoNum(1);
    }

    @Test
    void createLottoNum() {
        Assertions.assertThat(lottoNum).isEqualToComparingFieldByField(new LottoNum(1));
    }

    @Test
    void getLottoNumVaild() {
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new LottoNum(46));
    }

    @Test
    void Integerof() {
        Assertions.assertThat(lottoNum).isEqualToComparingFieldByField(LottoNum.of(1));
    }

    @Test
    void stringOf() {
        Assertions.assertThat(lottoNum).isEqualToComparingFieldByField(LottoNum.of(1));
    }

    @Test
    void validStringToInteger() {
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> LottoNum.of(""));
    }
}