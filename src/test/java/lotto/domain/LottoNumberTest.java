package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoNumberTest {

    @Test
    void generateLottoNumber(){
        int lottoNumber = 45;
        assertThat(new LottoNumber(lottoNumber)).isEqualTo(new LottoNumber(45));
    }

    @Test
    void maxValue_validation() {
        int lottoNumber = 46;
        assertThrows(IllegalArgumentException.class, ()->{
            new LottoNumber(lottoNumber);
        });
    }

    @Test
    void minValue_validation() {
        int lottoNumber = 0;
        assertThrows(IllegalArgumentException.class, ()->{
            new LottoNumber(lottoNumber);
        });
    }
}