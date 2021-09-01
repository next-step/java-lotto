package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoNumberTest {
    @Test
    void create() {
        LottoNumber lottoNumber = LottoNumber.of("1");
        assertThat(lottoNumber).isEqualTo(LottoNumber.of(1));
        assertThat(lottoNumber == LottoNumber.of(1)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void invalid_1부터_45사이의_값이_아니면_Exception(int num) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    LottoNumber.of(num);
                });
    }
}
