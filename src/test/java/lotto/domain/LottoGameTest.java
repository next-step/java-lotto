package lotto.domain;

import lotto.LottoApplication;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoGameTest {

    LottoGame lottoGame;

    @BeforeEach
    public void 테스트_데이터_생성() {
        lottoGame = LottoUtils.createLottoGame();
    }

    @Test
    public void 자동로또갯수() {
        assertThat(lottoGame.getAutoCount()).isEqualTo(10);
    }

//    @Test
//    public void 수동로또갯수() {
//        assertThat(lottoGame.getM()).isEqualTo(10);
//    }

}