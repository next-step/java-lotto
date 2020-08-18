package com.hskim.lotto.model;

import com.hskim.lotto.exception.LottoExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoNumberTest {

    @DisplayName("생성 테스트")
    @Test
    void create() {
        // given
        LottoNumber lottoNumber = new LottoNumber(5);

        // when & then
        assertThat(lottoNumber).isEqualTo(new LottoNumber(5));
    }

    @DisplayName("생성 실패 테스트 숫자가 LowBound 미만인경우")
    @Test
    void create_LowBound_미만_실패() {
        // when & then
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new LottoNumber(LottoNumber.LOW_BOUND - 1);
        }).withMessage(LottoExceptionMessage.LESS_THEN_LOW_BOUND.getMessage());
    }

    @DisplayName("생성 실패 테스트 숫자가 upperBound 초과인경우")
    @Test
    void create_upperBound_초과_실패() {
        // when & then
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new LottoNumber(LottoNumber.UPPER_BOUND + 1);
        }).withMessage(LottoExceptionMessage.EXCEED_UPPER_BOUND.getMessage());
    }
}
