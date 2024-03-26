package lotto;

import lotto.domain.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoProfitTest {

  private static LottoTickets MY_LOTTO_TICKETS;

  @BeforeAll
  static void beforeAll() {
    MY_LOTTO_TICKETS = new LottoTickets(PurchaseAmount.of(14000, 0),
        Set.of(
            LottoTicket.generate(Set.of(8, 21, 23, 41, 42, 43)),
            LottoTicket.generate(Set.of(3, 5, 11, 16, 32, 38)),
            LottoTicket.generate(Set.of(7, 11, 16, 35, 36, 44)),
            LottoTicket.generate(Set.of(1, 8, 11, 31, 41, 42)),
            LottoTicket.generate(Set.of(13, 14, 16, 38, 42, 45)),
            LottoTicket.generate(Set.of(7, 11, 30, 40, 42, 43)),
            LottoTicket.generate(Set.of(2, 13, 22, 32, 38, 45)),
            LottoTicket.generate(Set.of(23, 25, 33, 36, 39, 41)),
            LottoTicket.generate(Set.of(1, 3, 5, 14, 22, 45)),
            LottoTicket.generate(Set.of(5, 9, 38, 41, 43, 44)),
            LottoTicket.generate(Set.of(2, 8, 9, 18, 19, 21)),
            LottoTicket.generate(Set.of(13, 14, 18, 21, 23, 35)),
            LottoTicket.generate(Set.of(17, 21, 29, 37, 42, 45)),
            LottoTicket.generate(Set.of(3, 8, 27, 30, 35, 44))
        ));
  }

  @Test
  @DisplayName("당첨 번호 6개와 보너스 번호를 입력하여" +
      "`WinningNumbers` 를 생성할 수 있으며" +
      "로또 구매 금액 대비 당첨 금액 수익률 계산 기능 검증")
  void lottoProfitTest() {
    WinningNumbers winningNumbers = WinningNumbers.of(Set.of(1, 2, 3, 4, 5, 6), 7);
    LottoProfit lottoProfit = LottoProfit.of(winningNumbers, MY_LOTTO_TICKETS);
    assertThat(lottoProfit.calculateProfitRate()).isEqualTo(0.35);
  }

  @Test
  @DisplayName("당첨 번호 6개와 보너스 번호를 입력하여" +
      "`WinningNumbers` 를 생성할 수 있으며" +
      "로또 번호와 당첨 금액 숫자가 5개 매칭되고, 보너스 볼도 당첨 시 수익률 계산 기능 검증")
  void lottoProfitTest2() {
    WinningNumbers winningNumbers = WinningNumbers.of(Set.of(1, 3, 5, 14, 22, 40), 45);
    LottoProfit lottoProfit = LottoProfit.of(winningNumbers, MY_LOTTO_TICKETS);
    assertThat(lottoProfit.calculateProfitRate()).isEqualTo(2142.85);
  }
}
