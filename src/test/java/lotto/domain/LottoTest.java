package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    @Test
    public void winningResult() {
        // given
        Rank expectRank = Rank.FIRST;
        int[] winningNumbers = new int[]{1, 2, 3, 4, 5, 6};
        WinningNumber winningNumber = new WinningNumber(new int[]{1, 2, 3, 4, 5, 6});
        Lotto lotto = new Lotto(winningNumbers);

        // when
        Rank resultRank = lotto.winningResult(winningNumber);

        // then
        assertThat(resultRank).isEqualTo(expectRank);
    }

    @Test
    public void winningResults() {
        // given
        List<Rank> expectRanks = Arrays.asList(new Rank[]{Rank.FIRST, Rank.OTHER});
        int[] winningNumbers = new int[]{1, 2, 3, 4, 5, 6};
        WinningNumber winningNumber = new WinningNumber(winningNumbers);
        List<Lotto> lottoList = Arrays.asList(new Lotto[]{new Lotto(winningNumbers), new Lotto(new int[]{8, 9, 10, 11, 12, 13})});
        Lottos lottos = new Lottos(lottoList);

        // when
        List<Rank> resultRanks = lottos.winningResults(winningNumber);

        // then
        assertThat(resultRanks).isEqualTo(expectRanks);
    }

}
