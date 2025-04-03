package view;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import lotto.LottoEvent;
import lotto.LottoRank;
import lotto.LottoTicket;
import lotto.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PrintResultTest {

  @Test
  @DisplayName("로또 티켓 출력 테스트")
  void printLottoTicketTest() {
    PrintResult printResult = new PrintResult();
    User user = new MockUserImpl();
    String result = printResult.printUserLottoTickets(user);

    assertEquals("[1, 2, 3, 4, 5, 6]\n"
        + "[1, 2, 3, 4, 5, 7]\n", result);
  }

  @Test
  @DisplayName("Profit 출력 테스트")
  void printProfitTest() {
    PrintResult printResult = new PrintResult();
    User user = new MockUserImpl();
    String result = printResult.printUserProfit(user);

    assertEquals("당첨 통계\n"
        + "---------\n"
        + "3개 일치 (5000원)- 1개\n"
        + "4개 일치 (50000원)- 0개\n"
        + "5개 일치 (1500000원)- 0개\n"
        + "6개 일치 (2000000000원)- 0개\n"
        + "총 수익률은 1.00입니다.", result);

  }

  class MockUserImpl extends User {

    public MockUserImpl() {
      super(0, new LottoEvent());
    }

    @Override
    public List<LottoRank> evaluateLottoTickets() {
      return List.of(
          LottoRank.FOURTH,
          LottoRank.MISS,
          LottoRank.MISS,
          LottoRank.MISS,
          LottoRank.MISS
      );
    }

    @Override
    public List<LottoTicket> getLottoTickets() {

      return List.of(
          new LottoTicket(1, 2, 3, 4, 5, 6),
          new LottoTicket(1, 2, 3, 4, 5, 7)
      );
    }

    @Override
    public double calculateProfitRate() {
      return 1.00;
    }
  }


}