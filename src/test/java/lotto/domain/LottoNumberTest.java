package lotto.domain;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {4, 12, 44})
    void 로또번호_생성_테스트(int value) {
        LottoNumber lottoNumber = LottoNumber.generateByValue(value);
        assertThat(lottoNumber).isNotNull();
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46})
    void 로또번호_예외_테스트(int value) {
        assertThatThrownBy(() -> LottoNumber.generateByValue(value))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_랜덤_생성() {
        LottoNumber lottoNumber = LottoNumber.generateLottoNumber();
        assertThat(lottoNumber).isNotNull();
    }
}