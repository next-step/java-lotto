package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoWinningMachineTest {
    private Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    private LottoWinningMachine winningMachine = new LottoWinningMachine();

    @Test
    @DisplayName("당첨 숫자와 로또 번호를 비교해 당첨 개수를 반환한다.")
    void match_user_lotto_and_winning_lotto() {
        int count = winningMachine.checkCount(winningLotto, new Lotto(List.of(2, 1, 3, 5, 4, 6)));
        assertThat(count).isEqualTo(6);

        int count2 = winningMachine.checkCount(winningLotto, new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        assertThat(count2).isEqualTo(6);

        int count3 = winningMachine.checkCount(winningLotto, new Lotto(List.of(2, 10, 3, 5, 4, 23)));
        assertThat(count3).isEqualTo(4);

        int count4 = winningMachine.checkCount(winningLotto, new Lotto(List.of(32, 10, 3, 5, 4, 23)));
        assertThat(count4).isEqualTo(3);
    }


    @Test
    @DisplayName("등수 장 수에 대한 당첨 통계를 낸다.")
    void winning_result() {
        List<Lotto> lottos = List.of(
                new Lotto(List.of(2, 1, 3, 5, 4, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(2, 10, 3, 5, 4, 23)),
                new Lotto(List.of(32, 10, 3, 5, 4, 23))
        );

        Map<Rank, Integer> result = winningMachine.start(winningLotto, lottos);
        int count = result.get(Rank.FIRST);

        assertThat(count).isEqualTo(2);
    }

    @Test
    @DisplayName("등수 결과에 따른 수익률을 반환한다.")
    void rate_of_result() {
        Map<Rank, Integer> result = new HashMap<>();
        result.put(Rank.FIRST, 1);

        double rateOfResult = winningMachine.calculateRateOfResult(result, 2000000000);
        assertThat(rateOfResult).isEqualTo(1);
    }
}
