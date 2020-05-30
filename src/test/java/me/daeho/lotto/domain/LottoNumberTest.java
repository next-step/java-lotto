package me.daeho.lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoNumberTest {
    @Test
    public void equals_같은값() {
        LottoNumber one = LottoNumber.of(1);
        LottoNumber anotherOne = LottoNumber.of(1);

        assertEquals(one, anotherOne);
    }

    @Test
    public void equals_다른값() {
        LottoNumber one = LottoNumber.of(1);
        LottoNumber two = LottoNumber.of(2);

        assertNotEquals(one, two);
    }

    @Test
    public void of_범위_밖의_값() {
         assertThatThrownBy(() -> LottoNumber.of(46))
                 .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> LottoNumber.of(-10))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> LottoNumber.of(0))
                .isInstanceOf(IllegalArgumentException.class);
    }
}