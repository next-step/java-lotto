package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.fixture.LottoTicketFixture.LOTTO_TICKET1;
import static lotto.fixture.WinningNumbersFixture.WINNING_NUMBERS;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketTest {

    @DisplayName("당첨번호개수와 일치하는 숫자를 반환한다.")
    @Test
    void contains() {
        WinningNumbers winningNumbers = WINNING_NUMBERS;

        assertThat(LOTTO_TICKET1.countMatchWinningNumber(
                winningNumbers.getNumbers()))
                .isEqualTo(winningNumbers.getNumbers().size());
    }

}
