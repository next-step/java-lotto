package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoTicketsTest {

  @Test
  @DisplayName("자동 횟수 입력하면 해당 사이즈만큼 로또티켓이 있는 LottoTickets 객체 반환 테스트")
  public void create_자동() {
    LottoTickets lottoTickets = LottoTickets.createRandomLottoTickets(5);

    assertThat(lottoTickets.unmodifiedLottoTickets().size())
            .isEqualTo(5);
  }
}
