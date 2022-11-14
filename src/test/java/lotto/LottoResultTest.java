package lotto;

import lotto.domain.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class LottoResultTest {

    @Test
    void LottoResultTest() {
        Lottos lottos = new Lottos();
        lottos.add(Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6)));

        Integer[] winningLottoArr = {1,3,5,7,9,11};

        WinningLotto winningLotto = new WinningLotto(winningLottoArr);
        LottoResult lottoResult = new LottoResult(lottos, winningLotto);

        Map<Rank, Integer> expectedMap = new HashMap<>();
        expectedMap.put(Rank.FOURTH,1);

        assertThat(lottoResult.getLottoResult()).isEqualTo(expectedMap);
    }
}
