package lotto;

import lotto.domain.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class LottosTest {

    @Test
    void LottosAddAndGetSizeTest() {
        Lottos lottos = new Lottos();
        lottos.add(Lotto.of(Arrays.asList(1,2,3,4,5,6)));
        assertThat(lottos.getLottos().get(0).getLotto().get(1)).isEqualTo(LottoNumber.of(2));
        assertThat(lottos.getSize()).isEqualTo(1);
    }

    @Test
    void findLottoResultTest() {
        Map<Rank, Integer> lottoResult = new HashMap<>();

        Lottos lottos = new Lottos();
        lottos.add(Lotto.of(Arrays.asList(1,2,3,4,5,6)));

        Integer[] numbers = {1,2,3,4,5,6};
        WinningLotto winningLotto = new WinningLotto(numbers);

        Map<Rank, Integer> lottoExpected = new HashMap<>();
        lottoExpected.put(Rank.of(6),1);

        assertThat(lottos.findLottoResult(winningLotto)).isEqualTo(lottoExpected);

    }
}
