package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoNumberTest {

    @Test
    public void 랜덤숫자범위_1_45_아닐시_예외발생(){
        assertThrows(IllegalArgumentException.class, () -> {
            LottoNumber.of(46);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            LottoNumber.of(0);
        });
    }

}