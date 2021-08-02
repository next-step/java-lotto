package edu.nextstep.lotto.step2.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumberTest {

    @DisplayName("로또 번호 생성 테스트")
    @Test
    void create() {
        LottoNumber lottoNumber = new LottoNumber(new DefaultLottoShuffle());
        assertThat(lottoNumber.getLottoNumbers().size()).isEqualTo(6);
    }
}