package study.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {

    @DisplayName("구입한 모든 로또의 등수를 구한다.")
    @Test
    void ranks() {
        List<Integer> firstRankNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> secondRankNumbers = Arrays.asList(2, 3, 4, 5, 6, 45);
        Lottos lottos = new Lottos(Arrays.asList(
                new Lotto(firstRankNumbers),
                new Lotto(secondRankNumbers)
        ));
        LottoWinningNumber lottoWinningNumber =
                new LottoWinningNumber(firstRankNumbers, 45);

        WinningLottos winningLottos = lottos.ranks(lottoWinningNumber);
        assertThat(winningLottos.get(LottoRank.FIRST).size()).isEqualTo(1);
        assertThat(winningLottos.get(LottoRank.SECOND).size()).isEqualTo(1);
        assertThat(winningLottos.get(LottoRank.THIRD).size()).isEqualTo(0);
    }
}
