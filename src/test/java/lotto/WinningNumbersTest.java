package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class WinningNumbersTest {
    @DisplayName("당첨 번호가 6개가 아니면 예외가 발생한다.")
    @Test
    void of() {
        assertThatIllegalArgumentException().isThrownBy(() ->
                WinningNumber.from(List.of(1))
        );
    }

    @DisplayName("중복된 당첨 번호가 있으면 예외로 처리한다.")
    @Test
    void fromDuplicateNumberException() {
        assertThatIllegalArgumentException().isThrownBy(() ->
                WinningNumber.from(List.of(1, 1, 2, 3, 4, 5))
        );
    }
    @DisplayName("로또 티켓에 몇 개의 당점번호가 있는지 조회할 수 있다.")
    @Test
    void match() {
        WinningNumber winningNumber = WinningNumber.from(List.of(1, 2, 3, 4, 5, 6));
        LottoTicket.from(List.of(1, 2, 3, 4, 5, 7));

        int count = winningNumber.match(LottoTicket.from(List.of(1, 2, 3, 4, 5, 7)));

        assertThat(count).isEqualTo(5);

    }

}
