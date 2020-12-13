package step2.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class LottoGameTest {

    LottoGame lottoGame;

    @Test
    @DisplayName("구입한 금액만큼 로또 개수를 반환해주는 기능 테스트")
    void count() {
        lottoGame = new LottoGame(BigDecimal.valueOf(14000));
        Assertions.assertEquals(lottoGame.getCount(), 14);
    }
}