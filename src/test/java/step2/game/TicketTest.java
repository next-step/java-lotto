package step2.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step2.analyze.Prize;
import step2.analyze.WinningCount;
import step2.numbers.WinningLotto;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TicketTest {
    Ticket ticket = new Ticket(14, Collections.singletonList("4, 5, 6, 7, 8, 9"));

    @Test
    @DisplayName("입력된 금액만큼 로또가 구입되는지 확인")
    void buyTicketsTest() {
        assertThat(ticket.getCount(AutoGames.STRATEGY)).isEqualTo(14);
    }

    @Test
    @DisplayName("winningCount를 모두 계산 하는지 확인")
    void checkWinningCountTest() {
        WinningLotto winningLotto = new WinningLotto("1, 2, 3, 4, 5, 6", 7);
        WinningCount winningCount = ticket.checkWinningCount(winningLotto);
        int totalPrizeCount = 0;
        for (Prize prize : Prize.values()) {
            totalPrizeCount += winningCount.countOfPrize(prize);
        }
        assertThat(totalPrizeCount).isEqualTo(15);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 100, 1450})
    @DisplayName("로또구입시 금액 유효성 검증")
    void verifyAmountTest(int amount) {
        assertThrows(IllegalArgumentException.class, () -> Ticket.verifyAutoCount(amount, 1));
    }

    @Test
    @DisplayName("로또구입시 auto구입 금액 확인")
    void verifyAutoCount() {
        assertThat(Ticket.verifyAutoCount(14000, 10)).isEqualTo(4);
    }
}
