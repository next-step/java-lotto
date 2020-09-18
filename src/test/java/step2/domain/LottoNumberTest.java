package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.LottoNumber;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LottoNumberTest {
    @Test
    public void create() {
        LottoNumber lottoNumber = LottoNumber.of(1);
        assertEquals(lottoNumber, LottoNumber.of(1));
    }
    
    @Test
    @DisplayName("정상적이지 않은 로또 번호 체크")
    public void checkLottoNumber() {
        assertThrows(IllegalArgumentException.class, () -> LottoNumber.of(46));
        assertThrows(IllegalArgumentException.class, () -> LottoNumber.of(-1));
    }

}
