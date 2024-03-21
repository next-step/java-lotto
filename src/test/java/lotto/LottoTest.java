package lotto;

import lotto.domain.LottoGame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
public class LottoTest {

    @Test
    @DisplayName("입력값 몇게임인지 파악하는 메서드")
    void 몇게임() {
        LottoGame game = new LottoGame();
        assertThat(game.convertToGameUnit(14000)).isEqualTo(14);

    }
}
