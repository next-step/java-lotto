package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.LottoTicket;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTicketTest {

  @Test
  @DisplayName("로또 티켓을 생성에 성공한다")
  public void lottoTicketCreateTest() {
    LottoTicket.bySize(6);
  }

  @Test
  @DisplayName("같은 번호가 나온 수 만큼 반환한다")
  public void sameCountTest() {
    LottoTicket ticket = LottoTicket.bySize(6);

    assertThat(ticket.sameCount(ticket.numbers()))
        .isEqualTo(6);
  }
}