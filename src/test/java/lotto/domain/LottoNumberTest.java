package lotto.domain;

import org.junit.jupiter.api.Test;

public class LottoNumberTest {

    @Test
    public void 로또번호_생성() {
        LottoNumber number = new LottoNumber(new RandomNumber(30));
    }

}
