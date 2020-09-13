package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.LottoNumber;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LottoNumberTest {
    @Test
    public void create() {
        LottoNumber lottoNumber = new LottoNumber(1);
        assertEquals(lottoNumber, new LottoNumber(1));
    }
    
    @Test
    @DisplayName("정상적이지 않은 로또 번호 체크")
    public void checkLottoNumber() {
        assertThrows(IllegalArgumentException.class, () -> new LottoNumber(46));
        assertThrows(IllegalArgumentException.class, () -> new LottoNumber(-1));
    }

}
