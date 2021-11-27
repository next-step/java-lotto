package edu.nextstep.camp.lotto.domain;

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

    @Test
    public void toInt() {
        assertThat(LottoNumber.of(1).toInt()).isEqualTo(1);
    }

    @Test
    public void totalNumbers() {
        assertThat(LottoNumber.totalNumbers()).hasSize(45);
        assertThat(LottoNumber.totalNumbers()).hasOnlyElementsOfType(LottoNumber.class);
        assertThat(LottoNumber.totalNumbers()).contains(LottoNumber.of(1));
        assertThat(LottoNumber.totalNumbers()).contains(LottoNumber.of(45));
    }
}
