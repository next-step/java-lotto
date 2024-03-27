package lottoTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.Lotto;
import lotto.LottoNumber;
import lotto.LottoRank;
import lotto.Lottos;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottosTest {

    private static final Lottos lottos = new Lottos(
        List.of(
            new Lotto(
                Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                    new LottoNumber(4), new LottoNumber(5), new LottoNumber(6))),
            new Lotto(
                Arrays.asList(new LottoNumber(7), new LottoNumber(8), new LottoNumber(9),
                    new LottoNumber(10), new LottoNumber(11), new LottoNumber(12))))
    );

    @Test
    @DisplayName("당첨로또와 구입한 로또들을 비교하여 결과를 Return")
    void COMPARE_WINNING_LOTTO_WITH_PURCHASED_LOTTOS() {
        Lotto winningLotto = new Lotto(new String[] {"1","2","3","4","5","6"});

        Map<LottoRank, Integer> result = new HashMap<>();
        result.put(LottoRank.FIRST, 1);
        result.put(LottoRank.LOSE, 1);

        Assertions.assertThat(lottos.getWinningResult(winningLotto)).isEqualTo(result);
    }

}
