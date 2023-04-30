package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTicketTest {

  @Test
  @DisplayName("로또 티켓을 생성에 성공한다")
  public void lottoTicketCreateTest() {
    LottoTicket.bySize(6);
  }
}