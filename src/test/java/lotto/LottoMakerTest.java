package lotto;

import lotto.domain.LottoMaker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMakerTest {

    @Test
    @DisplayName("로또 생성 테스트")
    void makeLottoTest() {
        LottoMaker lottoMaker = new LottoMaker();
        System.out.println(lottoMaker.run());
    }

}