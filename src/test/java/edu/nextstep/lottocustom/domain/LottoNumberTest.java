package edu.nextstep.lottocustom.domain;

import edu.nextstep.lottocustom.exception.NumbersIllegalArgumentException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {

    @Test
    @DisplayName("LottoNumber 생성")
    void create() {
        // given
        int number = 1;

        // when
        LottoNumber lottoNumber = LottoNumber.of(number);

        // then
        assertThat(lottoNumber).isEqualTo(LottoNumber.of(1));
    }

    @ParameterizedTest(name = "LottoNumber 생성 실패 : 허용 범위 초과 {0}")
    @ValueSource(ints = {0, 46}) // given
    void create_fail_out_of_range(int number) {
        // when, then
        assertThatThrownBy(() -> LottoNumber.of(number))
                .isInstanceOf(NumbersIllegalArgumentException.class)
                .hasMessageContaining(LottoNumber.OUT_OF_RANGE_EXCEPTION_MESSAGE);
    }

}