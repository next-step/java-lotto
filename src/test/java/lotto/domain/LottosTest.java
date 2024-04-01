package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class LottosTest {
    @DisplayName("우승 로또와 몇 개가 일치하는지 통계를 낸다.")
    @Test
    void winningStatistic() {
        List<Integer> winNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto winner = new Lotto(winNumber);
        Integer bonusNumber = 0;

        List<Integer> buyNumber1 = Arrays.asList(1, 2, 3, 5, 6, 7);
        List<Integer> buyNumber2 = Arrays.asList(1, 2, 3, 10, 11, 12);

        Lotto lotto1 = new Lotto(buyNumber1);
        Lotto lotto2 = new Lotto(buyNumber2);

        Lottos lottos = new Lottos(List.of(lotto1, lotto2));
        Map<WinningType, Long> winningStatic = lottos.winningCount(winner, bonusNumber);

        Assertions.assertThat(winningStatic.get(WinningType.HIT_COUNT_3)).isEqualTo(1L);
        Assertions.assertThat(winningStatic.get(WinningType.HIT_COUNT_5)).isEqualTo(1L);
    }
}
