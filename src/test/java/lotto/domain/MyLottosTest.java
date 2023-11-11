package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MyLottosTest {

    @Test
    @DisplayName("로또다수/넣은로또만큼/생성된다.")
    void 로또를_여러개_생성한다() {
        // given
        List<Lotto> lottos = List.of(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));

        // when
        MyLottos myLottos = new MyLottos(lottos);

        // then
        assertThat(myLottos.getLottos()).hasSize(2);
    }
}