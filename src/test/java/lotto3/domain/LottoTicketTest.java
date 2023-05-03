package lotto3.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class LottoTicketTest {

  @Test
  void 이등로또에_당첨되는_경우_2등Prize가_반환_되는지_검증() {
    LottoTicket lottoTicket = new LottoTicket(List.of(1,2,3,4,5,7));

    WinningNumbers winningNumbers = new WinningNumbers(List.of(1,2,3,4,5,8));
    BonusNumber bonusNumber = new BonusNumber(7);

    Prize actualPrize = lottoTicket.getLottoPrize(winningNumbers, bonusNumber);

    assertThat(actualPrize).isEqualTo(Prize.SECOND);
  }
}