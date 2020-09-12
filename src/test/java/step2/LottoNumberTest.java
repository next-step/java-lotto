package step2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoNumberTest {
    @Test
    public void create() {
        LottoNumber lottoNumber = new LottoNumber(1);
        assertEquals(lottoNumber, new LottoNumber(1));
    }
}
