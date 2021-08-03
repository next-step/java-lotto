package edu.nextstep.lotto.step2.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumberTest {

    @DisplayName("로또 번호 생성 테스트")
    @Test
    void create() {
        LottoNumber lottoNumber = new LottoNumber(new DefaultLottoShuffle());
        assertThat(lottoNumber.getLottoNumbers().size()).isEqualTo(6);
    }

    @DisplayName("로또 번호 생성 테스트 (난수 알고리즘 변경)")
    @Test
    void create_again() {
        LottoNumber lottoNumber = new LottoNumber(() -> Arrays.asList(1,2,3,4,5,6,7,8,9,10));
        assertThat(lottoNumber.getLottoNumbers().size()).isEqualTo(10);
    }
}