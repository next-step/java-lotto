package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.*;

public class LottoResultTest {

    @Test
    void 수익률() {
        Lotto lotto = new Lotto("1, 2, 3, 7, 8, 9");
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(lotto);

        WinningLotto winningLotto = new WinningLotto("1,2,3,4,5,6");

        LottoResult lottoResult = new LottoResult(lottos,winningLotto);

        String result = lottoResult.calculateRateOfReturn();
        Assertions.assertThat(result).isEqualTo("5.00");

    }
}
