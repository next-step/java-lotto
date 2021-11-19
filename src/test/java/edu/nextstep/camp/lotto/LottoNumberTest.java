package edu.nextstep.camp.lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoNumberTest {
    @Test
    public void create() {
        assertThat(LottoNumber.of(1)).isEqualTo(LottoNumber.of(1));
        assertThat(LottoNumber.of(45)).isEqualTo(LottoNumber.of(45));
        assertThat(LottoNumber.of(1)).isNotEqualTo(LottoNumber.of(45));
    }


    @Test
    public void createFailed() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoNumber.of(0))
                .withMessageContaining("invalid input");
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoNumber.of(46))
                .withMessageContaining("invalid input");
    }

    @Test void toInt() {
        assertThat(LottoNumber.of(1).toInt()).isEqualTo(1);
    }
}
