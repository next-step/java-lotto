package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGameTest {

    @DisplayName("생성자 테스트")
    @Test
    public void constructor() throws Exception {
        LottoGame lottoGame = new LottoGame(new Money(10000));
    }


}
