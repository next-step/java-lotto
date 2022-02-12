package lotto.domain;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottosTest {

    @DisplayName("로또의_개수_사이즈_확인_테스트")
    @Test
    void countLottoCount() {
        Lottos lottos = LottoBundle.lottoBundle(5, new NonShuffleLottoNumber());
        assertThat(lottos.lottos()).isEqualTo(5);
    }
}