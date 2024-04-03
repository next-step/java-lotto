package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

public class LottosTest {
    @DisplayName("우승 로또와 몇 개가 일치하는지 통계를 낸다.")
    @Test
    void winningStatistic() {
        List<Integer> winNumber = List.of(1, 2, 3, 4, 5, 6);
        Lotto winner = new Lotto(winNumber);
        Integer bonusNumber = 45;
        WinningLotto winningLotto = new WinningLotto(winner, bonusNumber);

        List<Integer> buyNumber1 = List.of(1, 2, 3, 5, 6, 7);
        List<Integer> buyNumber2 = List.of(1, 2, 3, 10, 11, 12);
        Lotto lotto1 = new Lotto(buyNumber1);
        Lotto lotto2 = new Lotto(buyNumber2);
        Lottos lottos = new Lottos(List.of(lotto1, lotto2));

        LottoResult lottoResult = lottos.winningResult(winningLotto);

        LottoResult answer = new LottoResult(
                Map.of(
                        WinningType.HIT_COUNT_3, 1L,
                        WinningType.HIT_COUNT_5, 1L
                )
        );
        Assertions.assertThat(lottoResult)
                .usingRecursiveComparison()
                .isEqualTo(answer);
    }
}
