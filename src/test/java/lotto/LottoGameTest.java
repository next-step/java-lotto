package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoGameTest {
    @DisplayName("로또 발급")
    @Test
    void 로또_발급(){
        LottoGame lottoGame = new LottoGame(30000);
        assertThat(lottoGame.getLottoList()).hasSize(30);
    }
}
