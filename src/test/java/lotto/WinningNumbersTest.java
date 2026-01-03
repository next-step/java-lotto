package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningNumbersTest {

    @Test
    @DisplayName("보너스 번호는 당첨 번호와 중복될 수 없다")
    void bonusMustNotDuplicateWinningNumbers() {
        Lotto winning = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertThatThrownBy(() -> new WinningNumbers(winning, 6))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("WinningNumbers.match(ticket)은 Rank를 반환한다")
    void matchReturnsRank() {
        WinningNumbers winningNumbers = new WinningNumbers(new Lotto(List.of(1,2,3,4,5,6)), 7);

        Rank rank = winningNumbers.match(new Lotto(List.of(1,2,3,4,5,7)));

        assertThat(rank).isEqualTo(Rank.SECOND);
    }

    @Test
    @DisplayName("WinningNumbers.match(lottos)은 통계를 만들어 반환한다")
    void matchLottosReturnsStatistics() {
        WinningNumbers winningNumbers = new WinningNumbers(new Lotto(List.of(1,2,3,4,5,6)), 7);

        Lottos tickets = new Lottos(List.of(
            new Lotto(List.of(1,2,3,4,5,7)),   // SECOND
            new Lotto(List.of(1,2,3,4,5,10))   // THIRD
        ));

        WinningStatistics stats = winningNumbers.match(tickets);

        assertThat(stats.countOf(Rank.SECOND)).isEqualTo(1);
        assertThat(stats.countOf(Rank.THIRD)).isEqualTo(1);
    }
}
