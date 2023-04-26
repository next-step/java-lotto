package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoNumberTest {

    @Test
    @DisplayName("로또 번호 획득 테스트")
    void getLottNumber(){
         
        assertThat(LottoNumber.createLottoNumber(1)).isEqualTo(new LottoNumber(1));
    }
}