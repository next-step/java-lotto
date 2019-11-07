package com.seok2.lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.seok2.lotto.exception.LottoOutOfBoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoNumberTest {

    @Test
    void of() {
        assertThat(LottoNumber.of(1)).isEqualTo(LottoNumber.of(1));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void throwLottoOutOfBoundException(int number) {
        assertThatThrownBy(() ->LottoNumber.of(number))
            .isInstanceOf(LottoOutOfBoundException.class);
    }
}
