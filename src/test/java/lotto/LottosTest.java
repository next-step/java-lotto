package lotto;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class LottosTest {

    @Test
    void 수동로또확인() {
        List<Lotto> lottoList = Arrays.asList(
                Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6)),
                Lotto.of(Arrays.asList(7, 8, 9, 10, 11, 12)),
                Lotto.of(Arrays.asList(13, 14, 15, 16, 17, 18)));

        Lottos lottos = Lottos.createManualLottos(lottoList, 3);

        Assertions.assertThat(lottos).isIn(Lottos.createManualLottos(lottoList, 3));
    }
}
