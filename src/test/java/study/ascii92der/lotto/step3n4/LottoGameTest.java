package study.ascii92der.lotto.step3n4;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

class LottoGameTest {

    @Test
    void start() {
        LottoGame lottoGame = new LottoGame();
        lottoGame.start(new LottoPrice(13000),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new LottoNumber(11));
    }
}