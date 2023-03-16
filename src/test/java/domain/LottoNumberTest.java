package domain;

import org.junit.jupiter.api.Test;

public class LottoNumberTest {
    @Test
    void lottoNumberTest() {
        LottoNumber number = LottoNumber.valueOf(1);
        System.out.println(number.getNumber());
    }
}
