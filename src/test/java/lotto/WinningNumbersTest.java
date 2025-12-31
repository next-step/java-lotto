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
        BonusNumber bonus = BonusNumber.of(6);

        assertThatThrownBy(() -> new WinningNumbers(winning, bonus))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("티켓의 일치 개수와 보너스 일치 여부를 MatchResult로 반환한다")
    void matchReturnsMatchResult() {
        Lotto winning = new Lotto(1, 2, 3, 4, 5, 6);
        BonusNumber bonus = BonusNumber.of(7);
        WinningNumbers winningNumbers = new WinningNumbers(winning, bonus);

        Lotto ticket = new Lotto(1, 2, 3, 4, 5, 7); // 5개 + bonus
        MatchResult result = winningNumbers.match(ticket);

        assertThat(result.matchCount()).isEqualTo(5);
        assertThat(result.bonusMatched()).isTrue();
    }
}
