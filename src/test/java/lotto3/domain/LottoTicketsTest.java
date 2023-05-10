package lotto3.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class LottoTicketsTest {

  @Test
  void 당첨번호와_보너스번호를_맞춘경우_올바른_LottoResults를_가지는지_검증() {
    LottoTickets lottoTickets = new LottoTickets(
        List.of(
            new LottoTicket(List.of(1, 2, 3, 4, 5, 6)),
            new LottoTicket(List.of(1, 2, 3, 4, 5, 7)),
            new LottoTicket(List.of(1, 2, 3, 4, 5, 8))
        )
    );

    LottoNumbers winningNumbers = new LottoNumbers(List.of(1, 2, 3, 4, 5, 6));
    LottoNumber bonusNumber = new LottoNumber(7);

    LottoResults lottoResults = lottoTickets.calculateLotteryResults(winningNumbers, bonusNumber);


    assertThat(lottoResults.getMatchedCount(Prize.FIRST)).isEqualTo(1);
    assertThat(lottoResults.getMatchedCount(Prize.SECOND)).isEqualTo(1);
    assertThat(lottoResults.getMatchedCount(Prize.THIRD)).isEqualTo(1);
  }
}