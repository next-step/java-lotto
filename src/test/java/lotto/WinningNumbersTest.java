package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Rank;
import lotto.domain.WinningNumbers;
import lotto.domain.WinningStatistics;
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
}
