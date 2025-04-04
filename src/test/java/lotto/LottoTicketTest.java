package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTicketTest {

  @Test
  @DisplayName("로또 티켓은 숫자로 생성할 수 있다")
  void createLottoTicketWithNumbers() {
    assertThat(new LottoTicket(5, 1, 2, 3, 4, 6)).isEqualTo(new LottoTicket(1, 2, 3, 4, 5, 6));
  }


  @Test
  @DisplayName("로또 티켓은, 당첨번호와 일치하는 숫자의 갯수를 반환한다")
  void countMatchedNumbers() {
    LottoTicket lottoTicket = new LottoTicket(1, 2, 3, 4, 5, 6);
    LottoTicketNumberSet winningNumberSet = new LottoTicketNumberSet(
        List.of(
            new LottoTicketNumber(1),
            new LottoTicketNumber(2),
            new LottoTicketNumber(3),
            new LottoTicketNumber(4),
            new LottoTicketNumber(5),
            new LottoTicketNumber(6)
        )
    );
    assertThat(lottoTicket.countMatchingNumbers(winningNumberSet)).isEqualTo(6);
  }


}