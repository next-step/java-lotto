package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LottoWinningMachineTest {
    private final Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    private final LottoWinningMachine winningMachine = new LottoWinningMachine(winningLotto);


    @Test
    @DisplayName("맞춘 번호 개수에 맞는 Rank의 카운트를 반환한다.")
    void winning_result() {
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 23)),
                new Lotto(List.of(1, 2, 3, 4, 21, 23)),
                new Lotto(List.of(1, 2, 3, 20, 21, 23))
        );

        Map<Rank, Integer> result = winningMachine.getRankCounts(lottos);

        assertAll(
                () -> assertThat(result.get(Rank.FIRST)).isEqualTo(2),
                () -> assertThat(result.get(Rank.SECOND)).isEqualTo(1),
                () -> assertThat(result.get(Rank.THIRD)).isEqualTo(1),
                () -> assertThat(result.get(Rank.FOURTH)).isEqualTo(1),
                () -> assertThat(result.containsKey(Rank.ZERO)).isFalse()
        );
    }

    @Test
    @DisplayName("등수 결과에 따른 수익률을 반환한다.")
    void rate_of_result() {
        Map<Rank, Integer> result = new EnumMap<>(Rank.class);
        result.put(Rank.FIRST, 1);

        double rateOfResult = winningMachine.calculateRateOfResult(result, 2000000000);
        assertThat(rateOfResult).isEqualTo(1);
    }
}
