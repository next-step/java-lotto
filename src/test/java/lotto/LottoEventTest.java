package lotto;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoEventTest {

  @Test
  @DisplayName("로또 이벤트는 로또 티켓을 생성할 수 있다")
  void createLottoTicket() {
    LottoEventImpl lottoEvent = new LottoEventImpl();
    assertNotNull(lottoEvent);
  }

}