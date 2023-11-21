package com.fineroot.lotto.entity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.fineroot.lotto.util.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumberTest {
    @Test
    @DisplayName("LottoNumber 생성")
    void create() {
        LottoNumber lottoNumber = LottoNumber.from(1);
        assertThat(lottoNumber).isInstanceOf(LottoNumber.class);
    }

    @Test
    @DisplayName("LottoNumber 생성시 범위 초과 예외")
    void create_Exception() {
        assertThatThrownBy(() -> LottoNumber.from(-1)).hasMessageContaining(
                ExceptionMessage.LOTTO_NUMBER_OUT_OF_RANGE.getMessage());
    }

    @Test
    @DisplayName("toString 확인")
    void string() {
        LottoNumber lottoNumber = LottoNumber.from(1);
        assertThat(lottoNumber.toString()).hasToString("1");
    }
}
