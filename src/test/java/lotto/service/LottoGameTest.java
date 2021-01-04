package lotto.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoGameTest {
    private LottoGame lottoGame;

    @BeforeEach
    void setUp() {
        lottoGame = new LottoGame();
    }

    @Test
    @DisplayName("코인 생성 테스트")
    void createCoin() {
        assertThat(lottoGame.changeCoin(14500)).isEqualTo(14);
    }

    @Test
    @DisplayName("로또 구매 개수 테스트")
    void createLotto() {
        assertThat(lottoGame.createLottoNumber(15).buyLottoCount()).isEqualTo(15);
    }

    @Test
    @DisplayName("당첨 번호 생성 길이 체크 테스트")
    void createWinnerNumbers() {
        assertThat(lottoGame.createWinnerNumbers("1,2,3,4,5,6", 6).winnerNumberLength()).isEqualTo(6);
    }


}