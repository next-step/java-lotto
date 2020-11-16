package lotto.domain;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoGameTest {

    @DisplayName("LottoGame 생성 테스트")
    @Test
    void lottoGameConstructorTest(){
        // given
        int inputMoneyAmount = 14000;

        // when
        LottoGame lottoGame = new LottoGame(inputMoneyAmount);

        // then
        assertThat(lottoGame.getGameMoney()).isEqualTo(inputMoneyAmount);
    }

}
