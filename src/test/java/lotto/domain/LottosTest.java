package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {

    @Test
    public void 구매금액에_대한_로또_리스트_생성() {
        Lottos lottos = new Lottos().createAutoLottos(14000);
        assertThat(lottos.lottosSize()).isEqualTo(14);
    }

}
