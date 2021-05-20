package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameTest {

    @Test
    public void 로또게임_생성() {
        LottoGame game = new LottoGame();
        assertThat(game.isValid()).isTrue();
    }
}
