package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoNumberTest {

    @Test
    @DisplayName("로또 번호 생성 테스트(객체 동등성 테스트)")
    void createLottoNumber(){
        assertThat(LottoNumber.provideLottoNumber(1)).isEqualTo(new LottoNumber(1));
    }

    @Test
    @DisplayName("로또 번호 자동 생성 테스트(번호 범위 1~45)")
    void autoCreateLottoNumber(){

        LottoNumber beginOfLottoNumber = new LottoNumber(1);
        LottoNumber endOfLottoNumber = new LottoNumber(45);

        assertThat(LottoNumber.provideLottoNumber())
    }


}