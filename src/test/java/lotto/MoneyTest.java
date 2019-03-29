package lotto;

import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import lotto.domain.UserLottoTickets;
import lotto.domain.WiningLottoTicket;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class MoneyTest {

    private LotteryResults lotteryResults;

    @Test
    public void 티켓_구매_수() {
        Money money = new Money(3000);
        assertThat(money.getTotalTicketCount()).isEqualTo(3);
    }

    @Before
    public void setUp() throws Exception {
        LottoTicket fifthTicket = LottoTicket.of(1, 2, 3, 10, 11, 12);  //5등티켓
        LottoTicket secondTicket = LottoTicket.of(1, 2, 3, 4, 5, 7);    //2등티켓
        UserLottoTickets userLottoTickets = new UserLottoTickets();
        userLottoTickets.add(fifthTicket);
        userLottoTickets.add(secondTicket);
        lotteryResults = new LotteryResults(
            new WiningLottoTicket(LottoTicket.of(1, 2, 3, 4, 5, 6), LottoNumber.getBasicNumber(7)), userLottoTickets);
    }

    @Test
    public void 당첨_2등_1개_4등_1개_일때_TotalPrize() {
        Money money = new Money(2000);
        int totalPrize = money.getTotalPrize(lotteryResults.getLottoResults());

        //30_000_000 +  5_000
        assertThat(totalPrize).isEqualTo(30_005_000);
    }

    @Test
    public void 수익률_계산() {
        // 3000원 투자,   30_005_000 원을 이득 보았을때
        int testMoney = 3000;
        //  5_000 + 30_000_000
        int testTotal = LottoRank.FIFTH.getWinningMoney() + LottoRank.SECOND.getWinningMoney();

        // 3000원 투자,   30_005_000 원을 이득 보았을때
        Money money = new Money(3000);
        double profit = money.getProfit(lotteryResults);

        assertThat(testTotal / (double) testMoney).isEqualTo(profit);
    }
}
