package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGameTest {

    @Test
    @DisplayName("입력된 금액만큼의 로또가 생성되어야 한다")
    void generate_lotto() {
        assertThat(new LottoGame(14000).lottos()).hasSize(14);
    }

    @Test
    void winningResult() {
        assertThat(new LottoGame(14000).check(new Lotto(1, 2, 3, 4, 5, 6))).isNotNull();
    }

    @Test
    void winningResult2() {
        //new LottoGame();
    }
}