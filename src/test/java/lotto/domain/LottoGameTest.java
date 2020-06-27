package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoGameTest {

    private LottoGame lottoGame;
    private Money money;

    @BeforeEach
    public void setUp(){
        money = new Money(10000);
        lottoGame = new LottoGame(money, 2);
    }



    @DisplayName("한게임에 천원인 로또를 입력 10000원으로 수동입력 2개일때 자동 8개 출력")
    @Test
    void getSelectGame() {

        int autoGameCount = lottoGame.getAutoGame();
        assertThat(autoGameCount).isEqualTo(8);

    }

    @DisplayName("한게임에 천원인 로또를 10000원으로 몇개 살수 있는지")
    @Test
    void getBuyCountWithSpecificType() {
        int totalGameCount = lottoGame.getTotalGame();
        assertThat(totalGameCount).isEqualTo(10);
    }
}