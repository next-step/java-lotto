package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.domain.LottoRank;
import lotto.domain.LottoTicket;
import lotto.domain.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningNumbersTest {

    @Test
    @DisplayName("로또 티켓이 몇 등인지 알 수 있다.")
    void shouldReturnLottoRank() {
        // given
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 7);
        LottoTicket ticket = new LottoTicket(List.of(1, 2, 3, 4, 5, 7));

        // when
        LottoRank lottoRank = winningNumbers.getLottoRank(ticket);

        // then
        assertThat(lottoRank).isEqualTo(LottoRank.SECOND);
    }


    @Test
    @DisplayName("보너스 번호는 1부터 45 사이의 숫자여야 한다")
    void shouldHaveBonusNumberBetweenOneAndFortyFive() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        assertThatThrownBy(() -> new WinningNumbers(numbers, 0))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("로또 번호는 1부터 45 사이의 숫자여야 합니다.");

        assertThatThrownBy(() -> new WinningNumbers(numbers, 46))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @Test
    @DisplayName("보너스 번호는 로또 번호와 중복될 수 없다")
    void shouldNotHaveDuplicateBonusNumber() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        assertThatThrownBy(() -> new WinningNumbers(numbers, 1))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("보너스 번호는 로또 번호와 중복될 수 없습니다.");
    }

}
