package com.kakao.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

class LottoNumberTest {

    @Test
    @DisplayName("로또 숫자는 1부터 45사이이다.")
    void getValue() {
        assertThat(LottoNumber.of(1).getValue()).isEqualTo(1);
        assertThat(LottoNumber.of(45).getValue()).isEqualTo(45);
    }

    @Test
    @DisplayName("1부터 45외에 숫자를 입력하면 예외")
    void getValueFail() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoNumber.of(0));
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoNumber.of(46));
    }

    @Test
    @DisplayName("로또 생성시에는 기존에 만들어둔 객체를 사용한다")
    void lottoIdentifyObject() {
        assertThat(LottoNumber.of(1)).isEqualTo(LottoNumber.of(1));
    }
}
