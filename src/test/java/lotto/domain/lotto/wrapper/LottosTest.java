package lotto.domain.lotto.wrapper;

import lotto.domain.rankcount.RankCountGroup;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static lotto.domain.lotto.LotteryRank.*;
import static org.junit.jupiter.api.Assertions.*;

public class LottosTest {

    @DisplayName("당첨번호+보너스 번호를 인자로 받아 자신의 번호와 비교 후 일치 하는 개수 별로 그룹핑하여 각 그룹의 개수를 반환한다.")
    @Test
    void countByMatchingNumGroupWithBonusNumber() {
        // given
        Lottos lottos = new Lottos(
            List.of(
                new LottoNumbers(Set.of(1, 2, 3, 4, 5, 6)), //6
                new LottoNumbers(Set.of(1, 2, 3, 4, 5, 6)), //6
                new LottoNumbers(Set.of(1, 2, 3, 4, 5, 45)), //5+b
                new LottoNumbers(Set.of(1, 2, 3, 4, 5, 42)), //5
                new LottoNumbers(Set.of(1, 2, 3, 4, 7, 45)), //4
                new LottoNumbers(Set.of(1, 2, 3, 4, 7, 45)), //4
                new LottoNumbers(Set.of(1, 2, 3, 7, 8, 45))  //3
            ));

        WinningNumber winningNumber = new WinningNumber(Set.of(1, 2, 3, 4, 5, 6), 45);

        // when
        RankCountGroup rankCountGroup = lottos.groupByRank(winningNumber);

        // then
        assertAll(
            () -> assertEquals(2,rankCountGroup.findWinningCountBy(FIRST)),
            () -> assertEquals(1, rankCountGroup.findWinningCountBy(SECOND)),
            () -> assertEquals(1, rankCountGroup.findWinningCountBy(THIRD)),
            () -> assertEquals(2, rankCountGroup.findWinningCountBy(FOURTH)),
            () -> assertEquals(1, rankCountGroup.findWinningCountBy(FIFTH))
        );
    }
}
