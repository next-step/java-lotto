package edu.nextstep.camp.lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoNumberTest {
    @Test
    public void create() {
        assertThat(LottoNumber.of(1)).isEqualTo(LottoNumber.of(1));
        assertThat(LottoNumber.of(45)).isEqualTo(LottoNumber.of(45));
        assertThat(LottoNumber.of(1)).isNotEqualTo(LottoNumber.of(45));
    }


    @ParameterizedTest(name = "create failed: {arguments}")
    @ValueSource(ints = {0, 46})
    public void createFailed(int number) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoNumber.of(number))
                .withMessageContaining("invalid input");
    }


    @Test
    public void totalNumbers() {
        assertThat(LottoNumber.totalNumbers()).hasSize(45);
        assertThat(LottoNumber.totalNumbers()).hasOnlyElementsOfType(LottoNumber.class);
        assertThat(LottoNumber.totalNumbers()).contains(LottoNumber.of(1));
        assertThat(LottoNumber.totalNumbers()).contains(LottoNumber.of(45));
    }
}
