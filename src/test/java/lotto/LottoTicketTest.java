package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTicketTest {

  @Test
  @DisplayName("로또 티켓에는 6개의 로또 번호가 존재한다")
  void lottoTicketHas6LottoNumbers() {
    LottoTicket lottoTicket = new LottoTicket();

    int lottoNumbersSize = lottoTicket.getLottoNumbers().size();

    assertEquals(6, lottoNumbersSize);
  }

  @Test
  @DisplayName("로또 티켓에는 중복되지 않는 로또 번호가 존재한다")
  void lottoTicketHasUniqueLottoNumbers() {
    LottoTicket lottoTicket = new LottoTicket();

    boolean isUnique = lottoTicket.getLottoNumbers().stream().distinct().count() == 6;

    assertTrue(isUnique);
  }

}