package com.jaeyeonling.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumberTest {

    @DisplayName("LottoNumber 생성")
    @Test
    void create() {
        LottoNumber lottoNumber = new LottoNumber();
        
        assertThat(lottoNumber).isNotNull();
    }
}
