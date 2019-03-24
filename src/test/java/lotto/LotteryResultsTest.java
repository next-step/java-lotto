package lotto;

import lotto.domain.LottoTicket;
import lotto.domain.WiningLottoTicket;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class LotteryResultsTest {

    private LotteryResults lotteryResults;
    //4등티켓 2개와 3등 티켓 1개
    private List<LottoTicket> lottoTickets;
    private WiningLottoTicket winingLottoTicket;
    private int amount = 3000;


    @Before
    public void setUp() throws Exception {
        winingLottoTicket = new WiningLottoTicket(Arrays.asList(1, 10, 30, 40, 43, 44));
        lottoTickets = new ArrayList<>();
        LottoTicket fourthTicket = new LottoTicket(Arrays.asList(44, 30, 1, 2, 4, 5)); //4등
        LottoTicket fourthTicket2 = new LottoTicket(Arrays.asList(30, 40, 43, 11, 12, 13));//4등
        LottoTicket ThirdTicket = new LottoTicket(Arrays.asList(1, 10, 30, 44, 7, 8));//3등
        lottoTickets.add(fourthTicket);
        lottoTickets.add(fourthTicket2);
        lottoTickets.add(ThirdTicket);
        lotteryResults = new LotteryResults(winingLottoTicket, lottoTickets, amount);
    }

    @Test
    public void 당첨_4등2개_3등1개_결과값에_플러스1() {
        assertThat(lotteryResults.getLottoResults().get(LottoRank.FOURTH)).isEqualTo(2);
        assertThat(lotteryResults.getLottoResults().get(LottoRank.THIRD)).isEqualTo(1);
    }

    @Test
    public void 당첨_4등_2개_3등_1개_일때_TotalPrize() {
        // 5000 + 5000 + 50000
        assertThat(lotteryResults.getTotalPrize()).isEqualTo(60000);
    }

    @Test
    public void 수익률_계산() {
        // 3000원을 투자 60000만원 을 이득보았을때 수익률
        double profit = lotteryResults.getProfit();

        // 3000원을 투자 60000만원 을 이득보았을때 수익률
        double amount = 3000;
        int total = LottoRank.FOURTH.getWinningMoney() + LottoRank.FOURTH.getWinningMoney() + LottoRank.THIRD.getWinningMoney();

        assertThat(total / amount).isEqualTo(profit);
    }
}