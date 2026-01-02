package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningNumbersTest {
    @Test
    @DisplayName("보너스 번호는 당첨 번호와 중복될 수 없다")
    void bonusMustNotDuplicateWinningNumbers() {
        Lotto winning = new Lotto(1, 2, 3, 4, 5, 6);

        assertThatThrownBy(() -> new WinningNumbers(winning, 6))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("5개 일치 + 보너스 일치면 2등을 반환한다")
    void matchReturnsSecondRank() {
        WinningNumbers winningNumbers = new WinningNumbers(new Lotto(1, 2, 3, 4, 5, 6), 7);

        Rank rank = winningNumbers.match(new Lotto(1, 2, 3, 4, 5, 7));

        assertThat(rank).isEqualTo(Rank.SECOND);
    }

    @Test
    @DisplayName("5개 일치 + 보너스 불일치면 3등을 반환한다")
    void matchReturnsThirdRank() {
        WinningNumbers winningNumbers = new WinningNumbers(new Lotto(1, 2, 3, 4, 5, 6), 7);

        Rank rank = winningNumbers.match(new Lotto(1, 2, 3, 4, 5, 10));

        assertThat(rank).isEqualTo(Rank.THIRD);
    }
}
