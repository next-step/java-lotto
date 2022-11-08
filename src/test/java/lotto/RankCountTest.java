package lotto;

import lotto.domain.Lotto;
import lotto.domain.RankCount;
import lotto.domain.WinningNumbers;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static lotto.domain.Rank.*;

public class RankCountTest {
    @Test
    void fifthRank() {
        Lotto lotto = LottoFactory.createManualLotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        WinningNumbers winningNumbers = new WinningNumbers(Arrays.asList(1, 2, 3, 7, 9, 11), 13);

        RankCount rankCount = new RankCount();
        rankCount.countRank(lotto, winningNumbers);

        Assertions.assertThat(rankCount.numberOfRank(FIFTH)).isEqualTo(1);
    }

    @Test
    void fourthRank() {
        Lotto lotto = LottoFactory.createManualLotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        WinningNumbers winningNumbers = new WinningNumbers(Arrays.asList(1, 2, 3, 4, 9, 11), 13);

        RankCount rankCount = new RankCount();
        rankCount.countRank(lotto, winningNumbers);

        Assertions.assertThat(rankCount.numberOfRank(FOURTH)).isEqualTo(1);
    }

    @Test
    void thirdRank() {
        Lotto lotto = LottoFactory.createManualLotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        WinningNumbers winningNumbers = new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 11), 13);

        RankCount rankCount = new RankCount();
        rankCount.countRank(lotto, winningNumbers);

        Assertions.assertThat(rankCount.numberOfRank(THIRD)).isEqualTo(1);
    }

    @Test
    void secondRank() {
        Lotto lotto = LottoFactory.createManualLotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        WinningNumbers winningNumbers = new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 11), 6);

        RankCount rankCount = new RankCount();
        rankCount.countRank(lotto, winningNumbers);

        Assertions.assertThat(rankCount.numberOfRank(SECOND)).isEqualTo(1);
    }

    @Test
    void firstRank() {
        Lotto lotto = LottoFactory.createManualLotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        WinningNumbers winningNumbers = new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 6), 13);

        RankCount rankCount = new RankCount();
        rankCount.countRank(lotto, winningNumbers);

        Assertions.assertThat(rankCount.numberOfRank(FIRST)).isEqualTo(1);
    }

    @Test
    void winningMoney() {
        Lotto lotto = LottoFactory.createManualLotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        WinningNumbers winningNumbers = new WinningNumbers(Arrays.asList(1, 2, 3, 7, 9, 11), 13);

        RankCount rankCount = new RankCount();
        rankCount.countRank(lotto, winningNumbers);

        Assertions.assertThat(rankCount.winningAmount()).isEqualTo(5000);
    }
}
