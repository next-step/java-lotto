package lottoTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.Lotto;
import lotto.LottoNumber;
import lotto.LottoRank;
import lotto.Lottos;
import lotto.WinningLotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottosTest {

    private static final Lottos lottos = new Lottos(
        List.of(
            new Lotto(
                new String[]{"1", "2", "3", "4", "5", "6"})
        ));

    @Test
    @DisplayName("로또 결과 1등")
    void COMPARE_WINNING_LOTTO_THEN_FIRST_PRIZE() {
        WinningLotto winningLotto = new WinningLotto(
            new String[]{"1", "2", "3", "4", "5", "6"}, "7");

        Map<LottoRank, Integer> result = new HashMap<>();
        result.put(LottoRank.FIRST, 1);

        Assertions.assertThat(lottos.getWinningResult(winningLotto)).isEqualTo(result);
    }

    @Test
    @DisplayName("로또 결과 2등")
    void COMPARE_WINNING_LOTTO_WITH_SECOND_PRIZE() {
        WinningLotto winningLotto = new WinningLotto(
            new String[]{"1", "2", "3", "4", "5", "7"}, "6");

        Map<LottoRank, Integer> result = new HashMap<>();
        result.put(LottoRank.SECOND, 1);

        Assertions.assertThat(lottos.getWinningResult(winningLotto)).isEqualTo(result);
    }

    @Test
    @DisplayName("로또 결과 3등")
    void COMPARE_WINNING_LOTTO_WITH_THIRD_PRIZE() {
        WinningLotto winningLotto = new WinningLotto(
            new String[]{"1", "2", "3", "4", "5", "9"}, "10");

        Map<LottoRank, Integer> result = new HashMap<>();
        result.put(LottoRank.THIRD, 1);

        Assertions.assertThat(lottos.getWinningResult(winningLotto)).isEqualTo(result);
    }

}
