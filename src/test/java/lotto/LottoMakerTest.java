package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoMakerTest {

    @Test
    @DisplayName("로또 생성 테스트")
    void makeLottoTest() {
        LottoMaker lottoMaker = new LottoMaker();
        System.out.println(lottoMaker.makeLotto());
    }

}