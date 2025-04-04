package lotto;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTicketSellerTest {

  @Test
  @DisplayName("티켓 판매자는 로또 가격을 갖고있다.")
  void createLottoTicketSeller() {
    LottoTicketSeller lottoTicketSeller = new LottoTicketSeller(1000);
    assertNotNull(lottoTicketSeller);
  }

}