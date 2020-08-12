package lotto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class LottoResultNumberTest {

    @Test
    public void makeLottoResultNumberTest() {

        LottoNumber lottoNumber = new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoResultNumber lottoResultNumber = new LottoResultNumber(lottoNumber);
    }
}
