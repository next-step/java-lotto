package lotto.domain;

import lotto.domain.LottoNumber;
import lotto.domain.LottoResultNumber;
import lotto.domain.Number;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoNumberTest {

    @Test
    public void makeLottoNumberTest() {

        Number number = new Number(Arrays.asList(1, 2, 3, 4, 5, 6));

        LottoNumber lottoNumber = new LottoNumber(number);
        assertEquals(lottoNumber.getNumbers(), number.getNumbers());
    }

    @Test
    public void makeLottoResultNumberTest() {

        Number number = new Number(Arrays.asList(1, 2, 3, 4, 5, 6));

        LottoResultNumber lottoResultNumber = new LottoResultNumber(number);
        assertEquals(lottoResultNumber.getNumbers(), number.getNumbers());
    }
}
