package lotto;

import org.assertj.core.api.Assert;
import org.junit.jupiter.api.BeforeEach;
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
    void getLottoCount() {
        assertThat(lottoGame.getLottoCount(15000)).isEqualTo(15);
    }


}