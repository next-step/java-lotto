package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {

    @DisplayName("특정 숫자 만큼 로또 무작위로 생성")
    @Test
    void createLottos() {
        List<Lotto> lottos = new Lottos(10).getLottos();
        assertThat(lottos).hasSize(10);
        assertThat(lottos).doesNotHaveDuplicates();
    }
}