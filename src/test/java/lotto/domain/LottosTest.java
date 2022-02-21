package lotto.domain;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottosTest {

    @DisplayName("로또의_개수_사이즈_확인_테스트")
    @Test
    void countLottoCount() {
        LottoBundle lottoBundle = new LottoBundle(new ArrayList<>());
        List<Lotto> lottos = lottoBundle.lottoBundle(5, new NonShuffleLottoNumber());
        assertThat(lottos.size()).isEqualTo(5);
    }
}
