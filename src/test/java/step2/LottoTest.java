package step2;

import org.junit.jupiter.api.Test;

public class LottoTest {

    @Test
    public void 생성(){
        Lotto lotto = new Lotto(new LottoNumbers(
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(4),
                LottoNumber.of(5),
                LottoNumber.of(6),
                LottoNumber.of(7)
        ));

    }
}
