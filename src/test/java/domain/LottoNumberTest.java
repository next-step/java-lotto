package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import static org.junit.jupiter.api.Assertions.*;

class LottoNumberTest {
    @Test
    void 로또번호는1부터45까지만가능 () {
        assertThatThrownBy(()-> new LottoNumber(46))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 동등성비교(){
        final var number1 = new LottoNumber(1);
        final var number2 = new LottoNumber(1);
        assertThat(number1).isEqualTo(number2);
    }

}