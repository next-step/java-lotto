package com.lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoNumbersTest {

    @Test
    @DisplayName("1~45 로또 넘버를 shuffle 테스트")
    void shuffleTest() {
        LottoNumbers lottoNumbers = new LottoNumbers();
        assertThat(lottoNumbers).isEqualTo(new LottoNumbers());
        assertThat(lottoNumbers.shuffle()).isNotEqualTo(new LottoNumbers().shuffle());
        assertThat(lottoNumbers.shuffle().get(0)).isNotEqualTo(new LottoNumbers().shuffle().get(0));
    }
}