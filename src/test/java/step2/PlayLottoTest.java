package step2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PlayLottoTest {

    @Test
    void getLottoSize() {
        PlayLotto playLotto = new PlayLotto(3);
        assertThat(playLotto.getLottoSize()).isEqualTo(3);
    }
}