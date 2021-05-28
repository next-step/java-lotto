package kr.insup.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {

    @DisplayName("로또 번호 1개 생성")
    @Test
    void 로또_번호_1개_생성() {
        //given
        LottoNumber lottoNumber = LottoNumber.of(3);

        //then
        assertThat(lottoNumber).isEqualTo(LottoNumber.of(3));
    }

    @DisplayName("로또 번호 검증")
    @Test
    void 로또_번호_검증() {
        assertThatThrownBy(() -> LottoNumber.of(46)).isInstanceOf(IllegalArgumentException.class);
    }
}

