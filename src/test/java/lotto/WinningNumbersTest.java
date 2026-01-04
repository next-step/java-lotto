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
        LottoNumber bonus = LottoNumber.from(6);

        assertThatThrownBy(() -> new WinningNumbers(winning, bonus))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("5개 일치 + 보너스 일치이면 SECOND이다")
    void matchSecond() {
        WinningNumbers winningNumbers = new WinningNumbers(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);
        Lotto ticket = new Lotto(List.of(1, 2, 3, 4, 5, 7));

        assertThat(winningNumbers.match(ticket)).isEqualTo(Rank.SECOND);
    }

    @Test
    @DisplayName("여러 장의 로또를 매칭하면 등수별 당첨 횟수가 누적된다")
    void matchLottosReturnsStatistics() {
        WinningNumbers winningNumbers = new WinningNumbers(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);

        Lottos tickets = new Lottos(List.of(
            new Lotto(List.of(1, 2, 3, 4, 5, 7)),   // SECOND
            new Lotto(List.of(1, 2, 3, 4, 5, 10))   // THIRD
        ));

        WinningStatistics stats = winningNumbers.match(tickets);

        assertThat(stats.countOf(Rank.SECOND)).isEqualTo(1);
        assertThat(stats.countOf(Rank.THIRD)).isEqualTo(1);
    }
}
