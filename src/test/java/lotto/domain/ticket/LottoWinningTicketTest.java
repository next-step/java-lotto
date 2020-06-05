package lotto.domain.ticket;

import lotto.domain.dto.ManualNumberDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoWinningTicketTest {

    @DisplayName("당첨 번호와 보너스 번호가 중복 되는 것이 있으면 IllegalArgumentException throw")
    @Test
    void winningNumberDuplicateBonusNumberThrowException() {
        int bonusNumber = 5;

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoWinningTicket(new ManualNumberDto("1, 2, 3, 4, 5, 6"), bonusNumber))
                .withMessage("보너스 번호는 당첨 번호와 중복 될 수 없습니다. - " + bonusNumber);
    }

    @DisplayName("당첨 번호의 갯수가 6개가 아니면 IllegalArgumentException throw")
    @Test
    void lessOrMoreNumberThrowException() {
        int bonusNumber = 8;

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoWinningTicket(new ManualNumberDto("1, 2, 3, 4, 5, 6, 7"), bonusNumber))
                .withMessage("로또 번호는 6개만 가능합니다. - " + Arrays.asList(1, 2, 3, 4, 5, 6, 7));
    }

    @DisplayName("당첨 번호가 중복되는 값이 있다면 IllegalArgumentException throw")
    @Test
    void duplicatedWinningNumberThrowException() {
        int bonusNumber = 8;

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoWinningTicket(new ManualNumberDto("1, 2, 3, 3, 4, 5"), bonusNumber))
                .withMessageContaining("로또 번호는 중복 될 수 없습니다.");
    }
}