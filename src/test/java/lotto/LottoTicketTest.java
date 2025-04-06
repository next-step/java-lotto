package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTicketTest {

    @Test
    @DisplayName("로또 티켓은 6개의 숫자로 이루어져 있다.")
    void shouldHaveSixNumbers() {
        LottoTicket lottoTicket = new LottoTicket(List.of(1, 2, 3, 4, 5, 6));
        assertThat(6).isEqualTo(lottoTicket.getNumbers().size());
    }

    @Test
    @DisplayName("로또 티켓은 1부터 45 사이의 숫자로 이루어져 있다.")
    void shouldHaveNumbersBetweenOneAndFortyFive() {
        assertThatThrownBy(() -> new LottoTicket(List.of(0, 2, 3, 4, 5, 6)))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("로또 번호는 1부터 45 사이의 숫자여야 합니다.");

        assertThatThrownBy(() -> new LottoTicket(List.of(46, 2, 3, 4, 5, 6)))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @Test
    @DisplayName("로또 티켓은 중복된 숫자를 포함할 수 없다.")
    void shouldNotHaveDuplicateNumbers() {
        assertThatThrownBy(() -> new LottoTicket(List.of(1, 1, 3, 4, 5, 6)))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("로또 티켓은 중복된 숫자를 포함할 수 없습니다.");
    }

    @Test
    @DisplayName("로또 티켓끼리 비교하여 숫자가 얼마나 일치하는지 확인할 수 있다.")
    void shouldCompareLottoTickets() {
        LottoTicket lottoTicket1 = new LottoTicket(List.of(1, 2, 3, 4, 5, 6));

        assertThat(6).isEqualTo(lottoTicket1.countMatches(new LottoTicket(List.of(1, 2, 3, 4, 5, 6))));
        assertThat(5).isEqualTo(lottoTicket1.countMatches(new LottoTicket(List.of(7, 2, 3, 4, 5, 6))));
        assertThat(1).isEqualTo(lottoTicket1.countMatches(new LottoTicket(List.of(7, 8, 9, 10, 11, 6))));
        assertThat(0).isEqualTo(lottoTicket1.countMatches(new LottoTicket(List.of(7, 8, 9, 10, 11, 12))));
    }

    @Test
    @DisplayName("문자열로부터 로또 티켓을 생성한다")
    void shouldCreateLottoTicketFromString() {
        String numbersStr = "1,2,3,4,5,6";
        String bonusNumberStr = "7";

        LottoTicket ticket = new LottoTicket(numbersStr, bonusNumberStr);

        assertThat(ticket.getNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    @DisplayName("공백이 포함된 문자열로부터 로또 티켓을 생성한다")
    void shouldCreateLottoTicketFromStringWithSpaces() {
        String numbersStr = "1, 2, 3, 4, 5, 6";
        String bonusNumberStr = "7";

        LottoTicket ticket = new LottoTicket(numbersStr, bonusNumberStr);

        assertThat(ticket.getNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    @DisplayName("입력값이 null이면 예외가 발생한다")
    void shouldThrowExceptionWhenInputIsNull() {
        String numbersStr = null;
        String bonusNumberStr = "7";

        assertThatThrownBy(() -> new LottoTicket(numbersStr, bonusNumberStr))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("입력값이 없습니다.");
    }

    @Test
    @DisplayName("입력값이 비어있으면 예외가 발생한다")
    void shouldThrowExceptionWhenInputIsBlank() {
        String numbersStr = "";
        String bonusNumberStr = "7";

        assertThatThrownBy(() -> new LottoTicket(numbersStr, bonusNumberStr))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("입력값이 없습니다.");
    }

    @Test
    @DisplayName("숫자가 아닌 문자열이 포함되어 있으면 예외가 발생한다")
    void shouldThrowExceptionWhenInputContainsNonNumber() {
        String numbersStr = "1,2,3,4,5,a";
        String bonusNumberStr = "7";

        assertThatThrownBy(() -> new LottoTicket(numbersStr, bonusNumberStr))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("로또 번호는 숫자여야 합니다.");
    }

    @Test
    @DisplayName("보너스 번호는 1부터 45 사이의 숫자여야 한다")
    void shouldHaveBonusNumberBetweenOneAndFortyFive() {
        String numbersStr = "1,2,3,4,5,6";

        assertThatThrownBy(() -> new LottoTicket(numbersStr, "0"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("로또 번호는 1부터 45 사이의 숫자여야 합니다.");

        assertThatThrownBy(() -> new LottoTicket(numbersStr, "46"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @Test
    @DisplayName("보너스 번호는 로또 번호와 중복될 수 없다")
    void shouldNotHaveDuplicateBonusNumber() {
        String numbersStr = "1,2,3,4,5,6";

        assertThatThrownBy(() -> new LottoTicket(numbersStr, "1"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("보너스 번호는 로또 번호와 중복될 수 없습니다.");
    }

    @Test
    @DisplayName("보너스 번호가 숫자가 아닌 문자열이면 예외가 발생한다")
    void shouldThrowExceptionWhenBonusNumberIsNotNumber() {
        String numbersStr = "1,2,3,4,5,6";
        String bonusNumberStr = "a";

        assertThatThrownBy(() -> new LottoTicket(numbersStr, bonusNumberStr))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("로또 번호는 숫자여야 합니다.");
    }

}
