package lotto.domain;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoNumberTest {

    @Test
    void makeLottoNumberTest() {

        Number number = new Number(Arrays.asList(1, 2, 3, 4, 5, 6));

        LottoNumber lottoNumber = new LottoNumber(number);
        assertEquals(lottoNumber.getNumbers(), number.getNumbers());
    }

    @Test
    void makeLottoResultNumberTest() {

        Number number = new Number(Arrays.asList(1, 2, 3, 4, 5, 6));

        LottoResultNumber lottoResultNumber = new LottoResultNumber(number);
        assertEquals(lottoResultNumber.getNumbers(), number.getNumbers());
    }
}
