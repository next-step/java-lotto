package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGameTest {

    @DisplayName("로또 자동 생성")
    @Test
    void autoGenerate() {
        Lotto lotto = LottoGame.autoGenerate();
        assertThat(lotto).isNotNull();
    }
}