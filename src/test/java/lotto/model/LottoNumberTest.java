package lotto.model;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.Test;

class LottoNumberTest {
    @Test
    void LottoNumber는_1부터_45사이다(){
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(()->new LottoNumber(46));
    }
}