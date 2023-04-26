package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoNumberTest {

    @Test
    @DisplayName("로또 번호 생성 테스트(객체 동등성 테스트)")
    void createLottoNumber(){
        assertThat(LottoNumber.createLottoNumber(1)).isEqualTo(new LottoNumber(1));
    }

    @Test
    @DisplayName("로또 번호 자동 생성 테스트(번호 범위 1~45)")
    void autoCreateLottoNumber(){
        assertThat(LottoNumber.createLottoNumber()).isEqualTo(new LottoNumber(1));
    }


}