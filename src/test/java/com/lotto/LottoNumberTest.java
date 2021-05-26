package com.lotto;

import com.lotto.domain.LottoNumber;
import com.lotto.exception.LottoNumberOutOfBoundsException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46})
    void 로또번호_생성_실패_예외(int number) {
        assertThatThrownBy(() -> LottoNumber.valueOf(number)).isInstanceOf(LottoNumberOutOfBoundsException.class);
    }

    @Test
    void valueOf_성공() {
        LottoNumber lottoNumber1 = LottoNumber.valueOf(1);
        LottoNumber lottoNumber2 = LottoNumber.valueOf(1);

        assertThat(lottoNumber1).isEqualTo(lottoNumber2);
        assertThat(LottoNumber.valueOf(1)).isEqualTo(LottoNumber.valueOf(1));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46})
    void valueOf_범위예외(int number) {
        assertThatThrownBy(() -> LottoNumber.valueOf(number))
                .isInstanceOf(LottoNumberOutOfBoundsException.class);
    }
}
