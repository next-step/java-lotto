package lotto.domain.wrapper;

import lotto.domain.LotteryRank;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class LottosTest {

    @DisplayName("당첨번호를 인자로 받아 자신의 번호와 비교 후 일치 하는 개수 별로 그룹핑하여 각 그룹의 개수를 반환한다.")
    @Test
    void countByMatchingNumGroup() {
        // given
        Lottos lottos = new Lottos(
            List.of(
                new Numbers(List.of(1, 5, 12, 21, 32, 42)),
                new Numbers(List.of(1, 5, 12, 25, 35, 43)),
                new Numbers(List.of(3, 5, 17, 21, 32, 39)),
                new Numbers(List.of(1, 5, 24, 27, 29, 43)),
                new Numbers(List.of(1, 5, 12, 21, 32, 43))
            ));

        Numbers winningNumbers = new Numbers(List.of(1, 5, 12, 21, 32, 43));

        // when
        Map<Integer, Long> winners = lottos.countByMatchingNumGroup(winningNumbers);

        // then
        assertThat(winners.get(LotteryRank.FIRST.matchingCount())).isEqualTo(1);
        assertThat(winners.get(LotteryRank.SECOND.matchingCount())).isEqualTo(1);
        assertThat(winners.get(LotteryRank.THIRD.matchingCount())).isEqualTo(1);
        assertThat(winners.get(LotteryRank.FOURTH.matchingCount())).isEqualTo(2);
    }
}
