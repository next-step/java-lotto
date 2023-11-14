package lotto.domain.lotto;

import lotto.domain.lotto.Lottos;
import lotto.domain.rankcount.RankCountGroup;
import lotto.domain.wrapper.Numbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.domain.lotto.LotteryRank.*;
import static org.assertj.core.api.Assertions.*;

public class LottosTest {

    @DisplayName("당첨번호를 인자로 받아 자신의 번호와 비교 후 일치 하는 개수 별로 그룹핑하여 각 그룹의 개수를 반환한다.")
    @Test
    void countByMatchingNumGroup() {
        // given
        Lottos lottos = new Lottos(
            List.of(
                new Numbers(List.of(1, 5, 12, 21, 32, 43)),
                new Numbers(List.of(1, 5, 12, 21, 32, 42)),
                new Numbers(List.of(1, 5, 12, 21, 31, 44)),
                new Numbers(List.of(3, 7, 15, 22, 32, 43))
            ));

        Numbers winningNumbers = new Numbers(List.of(1, 5, 12, 21, 32, 43));

        // when
        RankCountGroup rankCountGroup = lottos.groupByRankCount(winningNumbers);

        // then
        assertThat(rankCountGroup.findWinningCountBy(FIRST)).isEqualTo(1);
        assertThat(rankCountGroup.findWinningCountBy(SECOND)).isEqualTo(1);
        assertThat(rankCountGroup.findWinningCountBy(THIRD)).isEqualTo(1);
        assertThat(rankCountGroup.findWinningCountBy(FOURTH)).isEqualTo(0);
    }
}
