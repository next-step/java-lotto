package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserImplTest {

  @Test
  @DisplayName("유저에게 14000원을 주면 14개의 티켓을 구매한다")
  void buyLottoTickets() {
    User user = new UserImpl(14000, new LottoEventImpl());
    user.buyAllLottoTickets();

    assertEquals(14, user.getLottoTickets().size());
  }

  @Test
  @DisplayName("유저가 5배의 수익을 내는 티켓 5장을 구매하면, 수익률은 500.0%이다")
  void createLottoResult() {
    FOURTHRankMockLottoEvent mockLottoEvent = new FOURTHRankMockLottoEvent();

    User user = new UserImpl(5000, mockLottoEvent);
    user.buyAllLottoTickets();

    assertEquals(user.getLottoTickets().size(), user.evaluateLottoTickets().size());
    assertEquals((double) LottoRank.FOURTH.getWinningAmount() / mockLottoEvent.getLottoTicketPrice(),
        user.calculateProfitRate());
  }


  private static class FOURTHRankMockLottoEvent implements LottoEvent {

    public FOURTHRankMockLottoEvent() {
    }

    @Override
    public LottoRank getRank(LottoTicket lottoTicket) {
      return LottoRank.FOURTH;
    }

    @Override
    public int getLottoTicketPrice() {
      return 1000;
    }

    @Override
    public void setWinningLottoTicketNumberSet(LottoTicketNumberSet winningLottoTicketNumberSet) {
      // do nothing
    }

    @Override
    public LottoTicket sellAutoLottoTicket() {
      return new LottoTicket();
    }
  }
}