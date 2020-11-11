package step2.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class LottosTest {
    @Test
    @DisplayName("로또의 갯수들이 로또티켓들의 갯수에 맞게 생성되는지 확인한다.")
    void create() {

        Lottos lottos = new Lottos(Arrays.asList(new Lotto(), new Lotto(), new Lotto()));
        Assertions.assertThat(lottos.isLottoTicketsCount(3)).isTrue();
    }
}
