package lotto.domain;

import lotto.exceptions.InvalidBonusNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class LottoWinningMachineTest {

    @Test
    @DisplayName("맞춘 번호 개수에 맞는 Rank의 카운트를 반환한다.")
    void winning_result() {
        LottoWinningMachine winningMachine = new LottoWinningMachine(30, 1, 2, 3, 4, 5, 6);

        Lottos lottos = new Lottos(List.of(
                new Lotto(1, 2, 3, 4, 5, 6),
                new Lotto(1, 2, 3, 4, 5, 30),
                new Lotto(1, 2, 3, 4, 5, 23),
                new Lotto(1, 2, 3, 4, 21, 23),
                new Lotto(1, 2, 3, 20, 21, 23)
        ));

        Map<Rank, Integer> result = winningMachine.getRankCounts(lottos);

        assertAll(
                () -> assertThat(result.get(Rank.FIRST)).isEqualTo(1),
                () -> assertThat(result.get(Rank.SECOND)).isEqualTo(1),
                () -> assertThat(result.get(Rank.THIRD)).isEqualTo(1),
                () -> assertThat(result.get(Rank.FOURTH)).isEqualTo(1),
                () -> assertThat(result.get(Rank.FIFTH)).isEqualTo(1),
                () -> assertThat(result.containsKey(Rank.ZERO)).isFalse()
        );
    }

    @Test
    @DisplayName("등수 결과에 따른 수익률을 반환한다.")
    void rate_of_result() {
        LottoWinningMachine winningMachine = new LottoWinningMachine(1, 2, 3, 4, 5, 6, 30);

        Map<Rank, Integer> result = new EnumMap<>(Rank.class);
        result.put(Rank.FIRST, 1);

        double rateOfResult = winningMachine.calculateRateOfResult(result, 2000000000);
        assertThat(rateOfResult).isEqualTo(1);
    }

    @Test
    @DisplayName("당첨 번호에 보너스 번호가 포함되어있다면 InvalidLottoException 예외를 던진다.")
    void winning_numbers_contains_bonus_number() {
        assertThatThrownBy(() -> new LottoWinningMachine(1, 1, 2, 3, 4, 5, 6))
                .isInstanceOf(InvalidBonusNumberException.class);
    }
}
